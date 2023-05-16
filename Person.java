public class Person
{
    private static String firstName;
    private static String lastName;
    public Person()
    {
        firstName = "";
        lastName = "";
    }
    public Person(String first)
    {
        firstName = first;
        lastName = "";
    }
    public Person(String first, String last)
    {
        firstName = first;
        lastName = last;
    }
    public void setFirstName(String first) { firstName = first; }
    public String getFirstName() { return firstName; }
    public void setLastName(String last) { lastName = last; }
    public String getLastName() { return lastName; }
    @Override
    public String toString()
    {
        if (!lastName.equals(""))
        {
            return firstName + " " + lastName;
        }
        else
        {
            return firstName;
        }
    }
}
