import java.util.Random;

public class Physical implements Award {
    public String[] prizes = {"Flat screen TV", "Free ice cream for a year", "MacBook Pro", "iPhone 14 Max", "Airpods"};
    public int getRandomPrize() {
        Random random = new Random();
        return random.nextInt(5);
    }
    @Override
    public int displayWinnings(Players player, boolean isTrue) {
        int thePrize = getRandomPrize();
        if (isTrue) {
            System.out.println(player + " is the winner!");
            System.out.println(prizes[thePrize] + " is your prize!\n");
        } else {
            System.out.println(player + " is incorrect!");
            System.out.println(prizes[thePrize] + " could have been your prize!\n");
        }
        return 0;
    }
}
