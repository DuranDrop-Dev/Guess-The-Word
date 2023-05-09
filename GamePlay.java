import java.util.Scanner;
public class GamePlay
{
    private static final Hosts host = new Hosts();
    private static final Players player = new Players();
    public static void main(String[] args)
    {
        // Create scanner and get user input
        Scanner name = new Scanner(System.in);

        // Host
        System.out.println("Enter first name for Host");
        host.setFirstName(name.nextLine());
        System.out.println("Enter last name for Host? To skip press Enter");
        host.setLastName(name.nextLine());

        // Player
        System.out.println("Enter first name for Player");
        player.setFirstName(name.nextLine());
        System.out.println("Enter last name for Player? To skip press Enter");
        player.setLastName(name.nextLine());

        // Generate a number for the gameplay
        host.randomizeNum();

        // Play game
        Turn turn = new Turn();
        turn.takeTurn(player,host);

        // Replay game
        if (turn.takeTurn(player, host)) {
            turn.takeTurn(player,host);
        }
    }
}
