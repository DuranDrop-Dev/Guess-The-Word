public class Hosts extends Person
{
    private String firstName;
    private String lastName;
    public Numbers newNumber = new Numbers();
    public Hosts() {
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
    public void randomizeNum() {
        newNumber.generateNumber();
    }
    @Override
    public String toString() {
        if (!this.getLastName().equals("")) {
            return this.getFirstName() + " " + this.getLastName();
        } else {
            return this.getFirstName();
        }
    }
}
