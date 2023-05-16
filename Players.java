public class Players extends Person
{
    private static String firstName;
    private static String lastName;
    private static double money = 1000;
    public Players() { super(); }
    public void setFirstName(String first) { firstName = first; }
    public void setLastName(String last) { lastName = last; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public void setMoney(double mon) { money = mon; }
    public double getMoney() { return money; }
    @Override
    public String toString()
    {
        if (!lastName.equals(""))
        {
            return firstName + " " + lastName + ":$" + String.format("%.2f", money);
        }
        else
        {
            return firstName + ":$" + String.format("%.2f", money);
        }
    }
}
