public class Hosts extends Person
{
    private static String firstName;
    private static String lastName;
    public static Numbers newNumber = new Numbers();
    public Hosts() {
        super();
    }
    public void setFirstName(String firstName) {
        Hosts.firstName = firstName;
    }
    public void setLastName(String lastName) {
        Hosts.lastName = lastName;
    }
    public static String getFirstName() {
        return firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public void randomizeNum() {
        newNumber.generateNumber();
    }
    @Override
    public String toString() {
        if (!Hosts.getLastName().equals("")) {
            return Hosts.getFirstName() + " " + Hosts.getLastName();
        } else {
            return Hosts.getFirstName();
        }
    }
}
