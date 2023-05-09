public class Person
{
    private static String firstName;
    private static String lastName;
    public Person() {
        firstName = "";
        lastName = "";
    }
    public Person(String firstName) {
        Person.firstName = firstName;
        Person.lastName = "";
    }
    public Person(String firstName, String lastName) {
        Person.firstName = firstName;
        Person.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        Person.firstName = firstName;
    }
    public static String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        Person.lastName = lastName;
    }
    public static String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        if (!Person.getLastName().equals("")) {
            return Person.getFirstName() + " " + Person.getLastName();
        } else  {
            return Person.getFirstName();
        }
    }
}
