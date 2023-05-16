public class Phrases {
    public static String gamePhrase;
    public static String playingPhrase;

    // TODO throwing exception, why?
    public static void findLetters(String guess) {
        try {
            if (guess.length() == 1) {
                char charGuess = guess.charAt(0);
                StringBuilder playingPhraseBuilt = new StringBuilder(playingPhrase);
                for (int i = 0; i < gamePhrase.length(); i++) {
                    if (gamePhrase.charAt(i) == charGuess) {
                        playingPhraseBuilt.setCharAt(i, charGuess);
                        playingPhrase = String.valueOf(playingPhraseBuilt);
                    }
                }
                System.out.println(playingPhraseBuilt);
            } else {
                throw new MultipleLettersException();
            }
        }
        catch (MultipleLettersException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setPlayingPhrase(String s) {
        String[] words = s.split(" ");
        StringBuilder newString = new StringBuilder();

        for (String w : words) {
            newString.append("_".repeat(w.length())).append(" ");
        }

        newString.deleteCharAt(newString.length()-1);
        playingPhrase = String.valueOf(newString);
        System.out.println(newString);
    }
    public void setPhrase(String phrase) {
        gamePhrase = phrase;
    }
    public String getPhrase() {
        return gamePhrase;
    }
    public boolean comparePhrase() {
        try {
            if (playingPhrase.equals(getPhrase())) {
                System.out.println("Congratulations, you have completed the phrase correctly!");
                return true;
            } else {
                System.out.println("Sorry your guess is incomplete!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}