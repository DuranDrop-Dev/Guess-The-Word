package src;

import Utilities.SoundHandler;

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
                ", please enter a letter for the game phrase! \n\n";
        GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
        GUI.gamePrompt.hostPrompt(msg);
        GUI.gamePrompt.setBackground(GUI.white);
        GUI.gbc.gridy = 7;
        GUI.contentPanel.add(GUI.gamePrompt, GUI.gbc);
        GUI.contentPanel.revalidate();
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
            GUI.saveMessages("Letters only, lose a turn!  \n");
        }
        catch (StringIndexOutOfBoundsException e)
        {
            GUI.saveMessages("Your guess cannot be blank!, lose a turn!  \n");
        }
        catch (Exception e)
        {
            GUI.saveMessages(e.getMessage());
        }

        // Check input
        if (!Phrases.comparePhrase())
        {
            // Wrong src.Money answer
            if  (prizeInteger == 1)
            {
                SoundHandler.RunMusic("Resources/audio/wrong.wav", 0);
                GUI.animateWrong();
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, false));
            }
            // Wrong src.Physical answer
            if (prizeInteger == 0)
            {
                SoundHandler.RunMusic("Resources/audio/wrong.wav", 0);
                GUI.animateWrong();
                physicalPrize.displayWinnings(player, false);
            }
            GUI.updatePlayerScoreBoard();
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            return false;
        }
        else
        {
            // src.Money Winner
            if (prizeInteger == 1)
            {
                SoundHandler.RunMusic("Resources/audio/victory.wav", 0);
                GUI.animateWin();
                player.setMoney(player.getMoney() + moneyPrize.displayWinnings(player, true));
            }
            // src.Physical Winner
            if (prizeInteger == 0)
            {
                SoundHandler.RunMusic("Resources/audio/victory.wav", 0);
                GUI.animateWin();
                physicalPrize.displayWinnings(player,true);
            }
            GUI.updatePlayerScoreBoard();
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            return true;
        }
    }
}
