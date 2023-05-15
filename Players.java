public class Players extends Person
{
    private String firstName;
    private String lastName;
    private double money = 1000;
    public Players() {
        super();
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public double getMoney() {
        return money;
    }
    @Override
    public String toString() {
        if (!this.getLastName().equals("")) {
            return this.getFirstName() + " " + this.getLastName() + ":$" + String.format("%.2f", getMoney());
        } else {
            return this.getFirstName() + ":$" + String.format("%.2f", getMoney());
        }
    }
}
