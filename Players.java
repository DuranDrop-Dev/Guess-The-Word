public class Players extends Person
{
    private static String firstName;
    private static String lastName;
    public static double money = 1000;
    public Players() {
        super();
    }
    public void setFirstName(String firstName) {
        Players.firstName = firstName;
    }
    public void setLastName(String lastName) {
        Players.lastName = lastName;
    }
    public static String getFirstName() {
        return firstName;
    }
    public static String getLastName() {
        return lastName;
    }

    public void setMoney(double money) {
        Players.money = money;
    }
    public double getMoney() {
        return money;
    }
    @Override
    public String toString() {
        if (!Players.getLastName().equals("")) {
            return Players.getFirstName() + " " + Players.getLastName() + " has $" + String.format("%.2f", money);
        } else {
            return Players.getFirstName() + " has $" + String.format("%.2f", money);
        }
    }
}
