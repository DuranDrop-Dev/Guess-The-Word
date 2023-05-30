import java.util.Scanner;
public class GamePlay
{
    private static final Hosts host = new Hosts();
    private static final Players[] currentPlayers = new Players[3];
    public static void displayScore()
    {
        System.out.println("SCORE");
        for (Players currentPlayer : currentPlayers) {
            System.out.println(currentPlayer);
        }
        System.out.println();
    }
    public static void main(String[] args) throws InterruptedException {
        // Create scanner and get user input
        Scanner name = new Scanner(System.in);

        // Host
        System.out.println("Enter first name for Host");
        host.setFirstName(name.nextLine());
        System.out.println("Enter last name for Host? To skip press Enter");
        host.setLastName(name.nextLine());

        // Players
        for (int i = 0; i < currentPlayers.length; i++) {
            currentPlayers[i] = new Players();
            System.out.println("Enter first name for Player " + (i+1));
            currentPlayers[i].setFirstName(name.nextLine());
            System.out.println("Enter last name for Player " + (i+1) + " Hit enter to skip");
            currentPlayers[i].setLastName(name.nextLine());
        }

        // Generate a phrase for the gameplay
        System.out.println("Host is choosing a phrase:");
        host.hostSetPhrase(name.nextLine());
        Phrases.setPlayingPhrase(Phrases.gamePhrase);

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
                System.out.println("Would like to keep playing? y for Yes or n for no");
                String s = name.nextLine();
                if (s.equals("n"))
                {
                    System.out.println("Goodbye...");
                    break;
                }

                // Generate a phrase for the gameplay
                System.out.println("Host is choosing a phrase:");
                host.hostSetPhrase(name.nextLine());
                Phrases.setPlayingPhrase(Phrases.gamePhrase);
            }
            // Rotate to player 1
            if (i==2)
            {
                i=-1;
            }
        }
    }
}
