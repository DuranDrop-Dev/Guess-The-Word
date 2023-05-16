public class Hosts extends Person
{
    private String firstName;
    private String lastName;
    private static final Phrases phrase = new Phrases();
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
    public void hostSetPhrase(String s) {
        phrase.setPhrase(s);
        // Display displayGamePhrase TESTING ONLY
        String displayGamePhrase = phrase.getPhrase();
        System.out.println("Game phrase: " + displayGamePhrase);
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
