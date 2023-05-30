import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Turn
{
    public static int getPrizeInt()
    {
        Random randomPrizeInt = new Random();
        return randomPrizeInt.nextInt(2);
    }
    public boolean takeTurn(Players player, Hosts host) throws InterruptedException
    {
        // Declarations
        Physical physicalPrize = new Physical();
        Money moneyPrize = new Money();
        int prizeInteger = getPrizeInt();

        // Initial Host prompt
        String msg = host + " says:\nPlayer " + player +
                ", please enter a letter for the game phrase!\n";
        GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
        GUI.gamePrompt.hostPrompt(msg);
        GUI.gamePrompt.setBackground(Color.LIGHT_GRAY);
        GUI.gbc.gridx = 0;
        GUI.gbc.gridy = 5;
        GUI.panel.add(GUI.gamePrompt, GUI.gbc);
        GUI.panel.revalidate();
        GUI.gamePrompt.wait();

        // Check input
        try
        {
            StringBuilder string = new StringBuilder(GUI.getPlayerGuess());
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
            GUI.saveMessages("Letters only, lose a turn!");
        }
        catch (StringIndexOutOfBoundsException e)
        {
            GUI.saveMessages("Your guess cannot be blank!, lose a turn!");
        }
        catch (Exception e)
        {
            GUI.saveMessages(e.getMessage());
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
