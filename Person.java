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
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        Person.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        if (!this.getLastName().equals("")) {
            return this.getFirstName() + " " + this.getLastName();
        } else  {
            return this.getFirstName();
        }
    }
}
