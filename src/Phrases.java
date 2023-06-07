package src;

import src.GUI;
import src.MultipleLettersException;

public class Phrases {
    public static String gamePhrase;
    public static String playingPhrase;

    public static void findLetters(String guess)
    {
        try
        {
            if (guess.length() == 1)
            {
                StringBuilder playingPhraseBuilt = new StringBuilder(playingPhrase);
                char charGuess = guess.charAt(0);

                for (int i = 0; i < gamePhrase.length(); i++)
                {
                    if (gamePhrase.charAt(i) == charGuess)
                    {
                        playingPhraseBuilt.setCharAt(i, charGuess);
                        playingPhrase = String.valueOf(playingPhraseBuilt);
                    }
                }
            }
            else
            {
                throw new MultipleLettersException();
            }
        }
        catch (MultipleLettersException e) {
            GUI.saveMessages(e.getMessage());
        }
    }
    public static void setPlayingPhrase(String s)
    {
        StringBuilder newString = new StringBuilder();
        String[] words = s.split(" ");

        for (String w : words)
        {
            newString.append("_".repeat(w.length())).append(" ");
        }

        newString.deleteCharAt(newString.length()-1);
        playingPhrase = String.valueOf(newString);
    }
    public static void setPhrase(String phrase) { gamePhrase = phrase; }
    public static String getPhrase() { return gamePhrase; }
    public static boolean comparePhrase()
    {
        try
        {
            if (playingPhrase.equals(getPhrase()))
            {
                GUI.textArea.append("Congratulations, you have completed the phrase correctly! \n");
                GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
                return true;
            }
            else
            {
                GUI.textArea.append("Your guess is incomplete! \n");
                GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
            }
        }
        catch (Exception e)
        {
            GUI.saveMessages(e.getMessage());
        }
        return false;
    }
}