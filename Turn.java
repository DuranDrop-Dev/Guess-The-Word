import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class Turn
{
    public static int getPrizeInt()
    {
        Random randomPrizeInt = new Random();
        return randomPrizeInt.nextInt(2);
    }

    public boolean takeTurn(Players player, Hosts host)
    {
        // Declarations
        // Scanner input = new Scanner(System.in);

        Physical physicalPrize = new Physical();
        Money moneyPrize = new Money();

        int prizeInteger = getPrizeInt();

        // Initial Host prompt
        try
        {
            /* System.out.println(host + " says:\nPlayer " + player +
                     ", please enter a letter for the game phrase!"); */
            String playerGuess = JOptionPane.showInputDialog(null, host +
                    " says:\nPlayer " + player + ", please enter a letter for the game phrase!");
            StringBuilder string = new StringBuilder(playerGuess);
            if (Character.isLetter(string.charAt(0)))
            {
                Phrases.findLetters(String.valueOf(string));
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e)
        {
            // System.out.println("Letters only, lose a turn!");
            JOptionPane.showMessageDialog(GUI.dialog, "Letters only, lose a turn!");
        }
        catch (StringIndexOutOfBoundsException e)
        {
            // System.out.println("Your guess cannot be blank!, lose a turn!");
            JOptionPane.showMessageDialog(GUI.dialog, "Your guess cannot be blank!, lose a turn!");
        }
        catch (Exception e)
        {
            // System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(GUI.dialog, e.getMessage());
        }

        // Check input
        if (!Phrases.comparePhrase())
        {
            // Wrong Money answer
            if  (prizeInteger == 1)
            {
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, false));
            }
            // Wrong Physical answer
            if (prizeInteger == 0)
            {
                physicalPrize.displayWinnings(player, false);
            }
            GUI.updatePlayerScoreBoard();
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            return false;
        }
        else
        {
            // Money Winner
            if (prizeInteger == 1)
            {
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, true));
            }
            // Physical Winner
            if (prizeInteger == 0)
            {
                physicalPrize.displayWinnings(player,true);
            }
            GUI.updatePlayerScoreBoard();
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            return true;
        }
    }
}
