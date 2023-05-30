import java.util.Random;

public class Physical implements Award {
    public static String[] prizes = {"Flat screen TV", "Free ice cream for a year", "MacBook Pro", "iPhone 14 Max", "Airpods"};
    public static int getRandomPrize()
    {
        Random random = new Random();
        return random.nextInt(5);
    }
    @Override
    public int displayWinnings(Players player, boolean isTrue)
    {
        int thePrize = getRandomPrize();
        if (isTrue)
        {
            GUI.textArea.append(player + " is the winner!\n" +
                prizes[thePrize] + " is your prize!\n");
        }
        else
        {
            GUI.textArea.append(player + " is incorrect!\n" +
                    prizes[thePrize] + " could have been your prize!");
            GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
        }
        return 0;
    }
}
