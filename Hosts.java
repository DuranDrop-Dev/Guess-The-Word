public class Hosts extends Person
{
    private static String firstName;
    private static String lastName;
    public Hosts() { super(); }
    public void setFirstName(String first) { firstName = first; }
    public void setLastName(String last) { lastName = last; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public void hostSetPhrase(String s)
    {
        Phrases.setPhrase(s);
        /* Display displayGamePhrase TESTING ONLY
         * String displayGamePhrase = Phrases.getPhrase();
         * System.out.println("Game phrase: " + displayGamePhrase);
         */
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
