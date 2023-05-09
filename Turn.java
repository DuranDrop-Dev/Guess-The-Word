import java.util.Scanner;

public class Turn
{
    public final double correctAnswer = 1000.00;
    public final double incorrectAnswer = 100.00;
    public boolean takeTurn(Players player, Hosts host) {
        int guess;
        Scanner input = new Scanner(System.in);
        Numbers newNum = new Numbers();

        // Initial Guess
        System.out.println(host + " says: " + player +
                "\nPlease enter a guess for the random number between 0 and 100");
        guess = Integer.parseInt(input.nextLine());

        // Try again
        while (!newNum.compareNumber(guess))
        {
            player.setMoney(player.getMoney() - incorrectAnswer);
            System.out.println(host + ": WRONG ANSWER! -$100.00!\n\n" + player + "\nPlease try again!");
            guess = Integer.parseInt(input.nextLine());
        }

        // Add win prize
        player.setMoney(player.getMoney() + correctAnswer);

        return true;
    }
}
