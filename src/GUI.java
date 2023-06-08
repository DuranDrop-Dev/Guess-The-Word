package src;

import Components.*;
import Utilities.SoundHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    public static final GamePrompt gamePrompt = new GamePrompt();
    public static boolean playerIsSet = false;
    public static boolean hostIsSet = false;
    public static Hosts host = new Hosts();
    public static JLabel hostName = new JLabel("Your Host");
    public static JTextArea playersName = new JTextArea();
    public static JLabel playingPhrase = new JLabel("_____");
    public static JButton startGame = new JButton("PLAY GAME");
    public static JTextArea textArea = new JTextArea(6, 20);
    public static JCheckBox saveMessages = new JCheckBox("Save Messages");
    public static GridBagConstraints gbc = new GridBagConstraints();
    public static String playerGuess = "";
    public static JScrollPane messageBox = new JScrollPane(textArea);
    public static Color translucent = new Color(0, 0, 0, 0);
    public static Color white = Color.WHITE;
    public static int FRAME_WIDTH = 1000;
    public static int FRAME_HEIGHT = 700;
    public static JFrame frame = new JFrame("WordGame");
    public static JComponent win = new WinComponent(100, 200);
    public static JComponent wrong = new WrongComponent(100, 100);
    public static JPanel panel = new JPanel();
    public static JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Main window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

            BGPanel.createPanel();
            panel.setPreferredSize(new Dimension(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT));
            panel.setLayout(new OverlayLayout(panel));

            JLabel title = new JLabel("WordGame");
            JMenuBar bar = new JMenuBar();
            JMenu gameMenu = new JMenu("Game");
            JMenuItem addPlayers = new JMenuItem("Add Players");
            JMenuItem addHostAndPhrase = new JMenuItem("Add Host");
            JMenu aboutMenu = new JMenu("About");
            JMenuItem layout = new JMenuItem("Layout");
            JMenuItem attribution = new JMenuItem("Media Attributions");
            DefaultCaret caret = (DefaultCaret) textArea.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

            // BG Music
            SoundHandler.RunMusic("Resources/audio/music.wav", -1);

            // Style
            Font regFont = new Font("arial", Font.BOLD, 12);
            Font titleFont = new Font("arial", Font.BOLD, 30);
            Font boldFont = new Font("arial", Font.BOLD, 25);
            Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.TRACKING, 0.1);
            Font phraseFont = boldFont.deriveFont(attributes);

            title.setFont(titleFont);
            title.setForeground(white);

            playingPhrase.setFont(phraseFont);
            playingPhrase.setForeground(white);

            playersName.setEditable(false);
            playersName.setText("Your Players");
            playersName.setFont(regFont);
            playersName.setBackground(translucent);
            playersName.setForeground(white);

            hostName.setFont(regFont);
            hostName.setBackground(translucent);
            hostName.setForeground(white);

            textArea.setText("PLEASE ADD NEW HOST & PLAYERS FROM THE GAME MENU\n\n");
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setFont(regFont);

            messageBox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            messageBox.setPreferredSize(new Dimension(400, 200));

            saveMessages.setToolTipText("Unchecking the box deletes old messages");
            saveMessages.setBackground(Color.WHITE);
            saveMessages.setSelected(true);

            // Menu
            bar.add(gameMenu);
            gameMenu.setMnemonic(KeyEvent.VK_G);
            gameMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
            gameMenu.add(addHostAndPhrase);
            gameMenu.add(addPlayers);

            bar.add(aboutMenu);
            aboutMenu.setMnemonic(KeyEvent.VK_A);
            aboutMenu.add(layout);
            aboutMenu.add(attribution);
            aboutMenu.setBorder(new EmptyBorder(10, 10, 10, 10));

            layout.addActionListener(e -> JOptionPane.showMessageDialog(null,
                    """
                            I chose the layout GridBagLayout because
                            I thought it could keep the components
                            centered easier than the others. Little
                            did I know it would have such a great learning
                            curb. Either way, I am pleased with the outcome."""));

            attribution.addActionListener(e -> JOptionPane.showMessageDialog(null,
                    """
                            All images courtesy of pixabay.com
                                https://pixabay.com/service/terms/
                                                        
                            Sounds:
                                -BG Music: "Piano loops 104 octave long loop 120 bpm.wav" by josefpres
                                    (License: CC0 Public Domain
                                        Link:https://freesound.org/people/josefpres/sounds/689379/)
                                -Wrong Buzzer: "sarahbuzzer.mp3" by nofeedbak
                                    (License: CC4 Attribution 4.0
                                        Link: https://freesound.org/people/nofeedbak/sounds/21871/)
                                -Winner SoundFX: "466133__humanoide9000__victory-fanfare.wav" by humanoide9000
                                    (License: CC4 Attribution 4.0
                                        Link: https://freesound.org/people/humanoide9000/sounds/466133/)"""));

            // Layout
            gbc.insets = new Insets(5, 50, 5, 50);

            gbc.gridx = 1;
            gbc.gridy = 0;
            contentPanel.add(title, gbc);

            gbc.gridy = 2;
            contentPanel.add(playingPhrase, gbc);

            gbc.gridy = 3;
            contentPanel.add(hostName, gbc);

            gbc.gridy = 4;
            contentPanel.add(playersName, gbc);

            gbc.gridy = 5;
            contentPanel.add(saveMessages, gbc);

            gbc.gridy = 6;
            contentPanel.add(messageBox, gbc);

            startGame.setVisible(false);
            gbc.gridy = 7;
            contentPanel.add(startGame, gbc);

            wrong.setVisible(false);
            panel.add(wrong);

            win.setVisible(false);
            panel.add(win);

            panel.add(contentPanel);

            frame.setContentPane(panel);
            frame.setJMenuBar(bar);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Add Host Listener
            addHostAndPhrase.addActionListener(e -> {
                try {
                    addHost();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });

            // Add Players Listener
            addPlayers.addActionListener(e -> {
                try {
                    addAllPlayers();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });

            // Start Game Listener
            startGame.addActionListener(e -> {
                startPlayingGame();
                startGame.setVisible(false);
            });
        });
    }

    public static void animateWin() {
        win.setVisible(true);
        WinComponent.yPosBalloon = 800;
    }

    public static void animateWrong() {
        wrong.setVisible(true);
        WrongComponent.yPosWrong = 800;
    }

    public static void addHost() {
        HostPrompt prompt = new HostPrompt();
        host = new Hosts();
        // Messages
        String firstName = "Enter a first name for host: \n";
        String lastName = "Enter last name for Host? \n";
        String phrase = "Choose a phrase \n\n";

        // Create prompt
        prompt.HostFirstName(firstName, lastName, phrase);
        prompt.setBackground(white);
        gbc.gridy = 7;
        contentPanel.add(prompt, gbc);
        contentPanel.revalidate();
    }

    public static void addAllPlayers() {
        String a1 = "Enter first name for Player 1";
        String a2 = "Enter last name for Player 1";

        String b1 = "Enter first name for Player 2";
        String b2 = "Enter last name for Player 2";

        String c1 = "Enter first name for Player 3";
        String c2 = "Enter last name for Player 3";

        PlayerPrompt prompt = new PlayerPrompt();
        prompt.Player1FirstName(a1, a2, b1, b2, c1, c2);
        prompt.setBackground(white);
        gbc.gridy = 7;
        contentPanel.add(prompt, gbc);
        contentPanel.revalidate();
    }

    public static void updatePlayerScoreBoard() {
        StringBuilder allPlayers = new StringBuilder();
        for (Players currentPlayer : PlayerPrompt.currentPlayers) {
            allPlayers.append(currentPlayer);
            allPlayers.append("\n\n");
        }
        playersName.setText(allPlayers.toString());
        contentPanel.revalidate();
    }

    public static void startPlayingGame() {
        // Clear startup text
        textArea.setText("");

        // Create a game
        Turn turn = new Turn();

        // Gameplay loop
        Thread loopThread = new Thread(() ->
        {
            for (int i = 0; i < PlayerPrompt.currentPlayers.length; i++) {
                synchronized (gamePrompt) {
                    try {
                        if (turn.takeTurn(PlayerPrompt.currentPlayers[i], host)) {
                            // Keep playing?
                            contentPanel.remove(gamePrompt);
                            contentPanel.revalidate();

                            int keepPlaying = JOptionPane.showConfirmDialog(null, "Would like to keep playing?");

                            if (keepPlaying == JOptionPane.YES_OPTION) {
                                contentPanel.remove(Physical.e);
                                contentPanel.revalidate();
                                textArea.setText("");
                                addHost();
                                gamePrompt.wait();
                                startGame.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                                contentPanel.remove(Physical.e);
                                contentPanel.revalidate();
                                panel.remove(gamePrompt);
                                panel.revalidate();
                                host = null;
                                hostIsSet = false;
                                playerIsSet = false;
                                startGame.setVisible(false);
                                System.gc();
                                textArea.setText("PLEASE ADD NEW HOST & PLAYERS FROM THE GAME MENU\n\n");
                                gamePrompt.wait();
                            }
                        }
                        // Rotate to player 1
                        if (i == 2) {
                            i = -1;
                        }
                    } catch (Exception e) {
                        textArea.append(e.getMessage());
                    }
                }
            }
        });
        loopThread.start();
    }

    public static void addStartButton() {
        if (playerIsSet && hostIsSet) {
            startGame.setVisible(true);
        }
    }

    public static void setPlayerGuess(String str) {
        playerGuess = str;
    }

    public static String getPlayerGuess() {
        return playerGuess;
    }

    public static void saveMessages(String str) {
        if (saveMessages.isSelected()) {
            textArea.append(str);
        } else {
            textArea.setText(str);
        }
    }
}
