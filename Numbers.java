import java.util.Random;

public class Numbers
{
    private static int randomNum;

    public void setRandomNum(int randomNum) {
        Numbers.randomNum = randomNum;
    }
    public int getRandomNum() {
        return randomNum;
    }
    public void generateNumber()
    {
        Random random = new Random();
        setRandomNum(random.nextInt(100));
    }
    public boolean compareNumber(int guess)
    {
        if (guess == getRandomNum()) {
            System.out.println("Congratulations, you guessed the number correctly!");
            return true;
        }
        if (guess > getRandomNum()) {
            System.out.println("I'm sorry. That guess was too high.");
            return false;
        }
        if (guess < getRandomNum()) {
            System.out.println("I'm sorry. That guess was too low.");
            return false;
        }
        return false;
    }
}
