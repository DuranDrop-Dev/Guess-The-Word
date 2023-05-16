public class Money implements Award{
    private final static int CORRECT = 1000;
    private final static int WRONG = -100;
    @Override
    public int displayWinnings(Players player, boolean isTrue)
    {
        if (isTrue)
        {
            System.out.println(player + " wins $1000!\n");
            return CORRECT;
        }
        else
        {
            System.out.println(player + " loses $100!\n");
            return WRONG;
        }
    }
}
