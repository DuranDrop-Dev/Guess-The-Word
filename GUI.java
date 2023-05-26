import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    private static final Players[] currentPlayers = new Players[3];
    private static final Hosts host = new Hosts();
    private static boolean playerIsSet = false;
    private static boolean hostIsSet = false;
    private static final JLabel hostName = new JLabel("", SwingConstants.CENTER);
    public static JButton addHostAndPhrase = new JButton("Host");
    public static JLabel playersName = new JLabel("", SwingConstants.CENTER);
    public static JButton addPlayers = new JButton("Players");
    public static final JLabel playingPhrase = new JLabel("PHRASE", SwingConstants.CENTER);
    private static final JLabel prompt = new JLabel("* Please add host & players!", SwingConstants.CENTER);
    public static JButton startGame = new JButton("PLAY GAME");
    public static JFrame frame = new JFrame("WordGame");
    public static JDialog dialog = new JDialog(frame, "Message", true);

    public static void main(String[] args) {
        // Predefined dimensions
        final int FRAME_WIDTH = 700;
        final int FRAME_HEIGHT = 500;
        final int BUTTON_WIDTH = 200;
        final int BUTTON_HEIGHT = 30;

        // Main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setBounds(0,0, FRAME_WIDTH, FRAME_HEIGHT);

        // Bounds and Sizes
        playingPhrase.setBounds((FRAME_WIDTH / 2) - 100,100, 200, 30);
        addPlayers.setBounds(FRAME_WIDTH - 300, 25, BUTTON_WIDTH, BUTTON_HEIGHT);
        playersName.setBounds(FRAME_WIDTH - 400, 15, 400,100);
        addHostAndPhrase.setBounds(100,25, BUTTON_WIDTH, BUTTON_HEIGHT);
        hostName.setBounds(100, 50,200,30);
        startGame.setBounds(FRAME_WIDTH / 2 - 125, FRAME_HEIGHT - 150, 250, 50);
        prompt.setBounds(FRAME_WIDTH / 2 - 125, FRAME_HEIGHT - 150, 250, 50);

        // Style
        Font font = new Font("serif", Font.BOLD, 25);
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.TRACKING, 0.1);
        Font font2 = font.deriveFont(attributes);
        playingPhrase.setFont(font2);
        playingPhrase.setForeground(Color.BLUE);

        // Layout
        startGame.setVisible(false);
        frame.add(startGame);
        frame.add(addHostAndPhrase);
        frame.add(hostName);
        frame.add(addPlayers);
        frame.add(playersName);
        frame.add(playingPhrase);
        frame.add(prompt);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add Host Listener
        addHostAndPhrase.addActionListener(e -> {
            addHost();
            addPhrase();
            addStartButton();
        });

        // Add Players Listener
        addPlayers.addActionListener(e -> {
            addAllPlayers();
            addStartButton();
        });

        // Start Game Listener
        startGame.addActionListener(e -> startPlayingGame());
    }
    public static void addHost() {
        String hostFirstName = JOptionPane.showInputDialog(null, "Enter first name for Host");
        host.setFirstName(hostFirstName);
        String hostLastName = JOptionPane.showInputDialog(null, "Enter last name for Host? Press ok to skip");
        host.setLastName(hostLastName);
        hostName.setText(host.toString());
    }
    public static void addPhrase() {
        String phrase = JOptionPane.showInputDialog(null, "Choose a phrase");
        host.hostSetPhrase(phrase);
        Phrases.setPlayingPhrase(Phrases.gamePhrase);
        playingPhrase.setText(Phrases.playingPhrase);
        hostIsSet = true;
    }
    public static void addAllPlayers() {
        for (int i = 0; i < currentPlayers.length; i++) {
            currentPlayers[i] = new Players();
            String enterFirstName = JOptionPane.showInputDialog(null, "Enter first name for Player " + (i+1));
            currentPlayers[i].setFirstName(enterFirstName);
            String enterLastName = JOptionPane.showInputDialog(null, "Enter last name for Player " + (i+1) + " Hit enter to skip");
            currentPlayers[i].setLastName(enterLastName);
        }
        updatePlayerScoreBoard();
        playerIsSet = true;
    }
    public static void updatePlayerScoreBoard() {
        StringBuilder allPlayers = new StringBuilder();
        for (Players currentPlayer : currentPlayers) {
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
        for (int i = 0; i < currentPlayers.length; i++)
        {
            if (turn.takeTurn(currentPlayers[i], host))
            {
                // Show score
                displayScore();

                // Keep playing?
                int keepPlaying = JOptionPane.showConfirmDialog(dialog, "Would like to keep playing?");
                if (keepPlaying == 1)
                {
                    JOptionPane.showMessageDialog(dialog, "Goodbye");
                    System.exit(1);
                    break;
                }
                addPhrase();
            }
            // Rotate to player 1
            if (i==2)
            {
                i=-1;
            }
        }
    }
    public static void addStartButton() {
        if (playerIsSet && hostIsSet) {
            startGame.setVisible(true);
        }
    }
    public static void displayScore()
    {
        StringBuilder showScore = new StringBuilder();
        for (Players currentPlayer : currentPlayers) {
            showScore.append(currentPlayer).append("\n");
        }
        JOptionPane.showMessageDialog(dialog, "SCORE\n" + showScore);
    }
}
