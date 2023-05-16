import java.util.Scanner;
import java.util.Random;

public class Turn
{
    public int getPrizeInt() {
        Random randomPrizeInt = new Random();
        return randomPrizeInt.nextInt(2);
    }

    public boolean takeTurn(Players player, Hosts host) {
        // Declarations
        Money moneyPrize = new Money();
        Physical physicalPrize = new Physical();
        Phrases phrase = new Phrases();
        Scanner input = new Scanner(System.in);
        int prizeInteger = getPrizeInt();

        // Initial Host prompt
        System.out.println(host + " says:\nPlayer " + player +
                ", please enter a guess for the game phrase!");
        Phrases.findLetters(input.nextLine());

        // Check input
        if (!phrase.comparePhrase()) {
            // Wrong Money answer
            if  (prizeInteger == 1) {
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, false));
            }
            // Wrong Physical answer
            if (prizeInteger == 0) {
                physicalPrize.displayWinnings(player, false);
            }
            return false;
        } else {
            // Money Winner
            if (prizeInteger == 1) {
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, true));
            }
            // Physical Winner
            if (prizeInteger == 0) {
                physicalPrize.displayWinnings(player,true);
            }
            return true;
        }
    }
}
