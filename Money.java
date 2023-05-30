public class Money implements Award{
    private final static int CORRECT = 1000;
    private final static int WRONG = -100;
    @Override
    public int displayWinnings(Players player, boolean isTrue)
    {
        if (isTrue)
        {
            GUI.textArea.append(player + " wins $1000!\n");
            return CORRECT;
        }
        else
        {
            GUI.textArea.append(player + " loses $100!\n");
            GUI.verticalScrollBar.setValue(GUI.verticalScrollBar.getMaximum());
            return WRONG;
        }
    }
}
