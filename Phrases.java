import javax.swing.*;

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
                // System.out.println(playingPhraseBuilt);
                // JOptionPane.showMessageDialog(null, playingPhraseBuilt);
            }
            else
            {
                throw new MultipleLettersException();
            }
        }
        catch (MultipleLettersException e) {
            // System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        // System.out.println("The phrase to guess is: " + newString);
        // JOptionPane.showMessageDialog(null, "The phrase to guess is: " + newString);
    }
    public static void setPhrase(String phrase) { gamePhrase = phrase; }
    public static String getPhrase() { return gamePhrase; }
    public static boolean comparePhrase()
    {
        try
        {
            if (playingPhrase.equals(getPhrase()))
            {
                // System.out.println("Congratulations, you have completed the phrase correctly!");
                JOptionPane.showMessageDialog(null,
                        "Congratulations, you have completed the phrase correctly!");
                return true;
            }
            else
            {
                // System.out.println("Your guess is incomplete!");
                JOptionPane.showMessageDialog(null, "Your guess is incomplete!");
            }
        }
        catch (Exception e)
        {
            // System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
}