import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    public static Hosts host = new Hosts();
    public static boolean playerIsSet = false;
    public static boolean hostIsSet = false;
    public static JTextPane hostName = new JTextPane();
    public static JTextArea playersName = new JTextArea();
    public static final JLabel playingPhrase = new JLabel("WordGame", SwingConstants.CENTER);
    public static JButton startGame = new JButton("PLAY GAME");
    public static JFrame frame = new JFrame("WordGame");
    public static JPanel panel = new JPanel(new GridBagLayout());
    public static JDialog dialog = new JDialog(frame, "Message", true);
    public static JMenuBar bar = new JMenuBar();
    public static JMenu gameMenu = new JMenu("Game");
    public static JMenuItem addPlayers = new JMenuItem("Add Players");
    public static JMenuItem addHostAndPhrase = new JMenuItem("Add Host");
    public static JMenu aboutMenu = new JMenu("About");
    public static JMenuItem layout = new JMenuItem("Layout");
    public static JTextArea textArea = new JTextArea(6, 20);
    public static JCheckBox saveMessages = new JCheckBox("Save Messages");
    public static GridBagConstraints gbc = new GridBagConstraints();
    public static String playerGuess = "";
    public static final GamePrompt gamePrompt = new GamePrompt();
    public static final HostPrompt prompt = new HostPrompt();
    public static JScrollPane messageBox = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public static JScrollBar verticalScrollBar = messageBox.getVerticalScrollBar();

    public static void main(String[] args) {
        // Predefined dimensions
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 700;

        // Main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        panel.setBackground(Color.LIGHT_GRAY);

        messageBox.setPreferredSize(new Dimension(400,200));

        textArea.setText("* Please add host & players from the Game menu!\n");
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        // Style
        Font regFont = new Font("arial", Font.BOLD, 12);
        Font phraseFont = new Font("arial", Font.BOLD, 25);
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.TRACKING, 0.1);
        Font font2 = phraseFont.deriveFont(attributes);

        playingPhrase.setFont(font2);
        playingPhrase.setForeground(Color.DARK_GRAY);

        playersName.setEditable(false);
        playersName.setText("Your Players");
        playersName.setFont(regFont);
        playersName.setBackground(Color.LIGHT_GRAY);

        hostName.setEditable(false);
        hostName.setText("Your Host");
        hostName.setFont(regFont);
        hostName.setBackground(Color.LIGHT_GRAY);

        layout.addActionListener(e -> JOptionPane.showMessageDialog(null,
            """
                I chose the layout GridBagLayout because
                I thought it could keep the components
                centered easier than the others. Little
                did I know it would have such a great learning
                curb. Either way, I am pleased with the outcome."""));

        saveMessages.setToolTipText("Unchecking the box deletes old messages");
        saveMessages.setBackground(Color.LIGHT_GRAY);
        saveMessages.setSelected(true);

        textArea.setFont(regFont);

        // Menu
        bar.add(gameMenu);
        gameMenu.setMnemonic(KeyEvent.VK_G);
        gameMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
        gameMenu.add(addHostAndPhrase);
        gameMenu.add(addPlayers);

        bar.add(aboutMenu);
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        aboutMenu.add(layout);
        aboutMenu.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Layout
        gbc.insets = new Insets(10, 10, 10, 10);
/*
        ImageIcon backgroundImage = new ImageIcon("image.jpg");
        backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(1200,900, Image.SCALE_DEFAULT));
        JLabel myLabel = new JLabel(backgroundImage);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = panel.getWidth();
        panel.add(myLabel, gbc);
*/
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playingPhrase);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(hostName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(playersName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(saveMessages, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(messageBox, gbc);

        startGame.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(startGame, gbc);

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
    }

    public static void addHost() {
        // Messages
        String firstName = "Enter a first name for host: \n";
        String lastName = "Enter last name for Host?\n";
        String phrase = "Choose a phrase\n";

        // Create prompt
        prompt.HostFirstName(firstName, lastName, phrase);
        prompt.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(prompt, gbc);
        frame.revalidate();
    }

    public static void addAllPlayers() {
        String a1 = "Enter first name for Player 1";
        String a2 = "Enter last name for Player 1";

        String b1 = "Enter first name for Player 2";
        String b2 = "Enter last name for Player 2";

        String c1 = "Enter first name for Player 3";
        String c2 = "Enter last name for Player 3";

        PlayerPrompt prompt = new PlayerPrompt();
        prompt.Player1FirstName(a1,a2,b1,b2,c1,c2);
        prompt.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(prompt, gbc);
        frame.revalidate();
    }
    public static void updatePlayerScoreBoard() {
        StringBuilder allPlayers = new StringBuilder();
        for (Players currentPlayer : PlayerPrompt.currentPlayers) {
            allPlayers.append(currentPlayer);
            allPlayers.append("\n");
        }
        playersName.setText(allPlayers.toString());
        frame.revalidate();
    }
    public static void startPlayingGame() {
        // Create a game
        Turn turn = new Turn();

        // Gameplay loop
        Thread loopThread = new Thread(() ->
        {
            for (int i = 0; i < PlayerPrompt.currentPlayers.length; i++)
            {
                synchronized (gamePrompt)
                {
                    try {
                        if (turn.takeTurn(PlayerPrompt.currentPlayers[i], host)) {
                            // Keep playing?
                            panel.remove(gamePrompt);
                            panel.revalidate();

                            int keepPlaying = JOptionPane.showConfirmDialog(dialog, "Would like to keep playing?");
                            if (keepPlaying == 1) {
                                JOptionPane.showMessageDialog(dialog, "Goodbye");
                                System.exit(1);
                            }
                            textArea.setText("");
                            addHost();
                            gamePrompt.wait();
                            startGame.setVisible(false);
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
