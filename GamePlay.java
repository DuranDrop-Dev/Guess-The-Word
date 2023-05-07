import java.util.Scanner;
public class GamePlay
{
    private static Person person = new Person("","");
    public static void main(String[] args)
    {

        Scanner name = new Scanner(System.in);
        System.out.println("Enter first name");
        person.setFirstName(name.nextLine());
        System.out.println("Enter last name? To skip press Enter");
        person.setLastName(name.nextLine());

        Numbers newNum = new Numbers();
        newNum.generateNumber();
        int guess;
        System.out.println(person.getFirstName() + " " + person.getLastName() +
                ", guess what number I picked between 0 and 100.");
        guess = Integer.parseInt(name.nextLine());

        while (!newNum.compareNumber(guess))
        {
            System.out.println(person.getFirstName() + " " + person.getLastName() +
                    ", guess what number I picked between 0 and 100.");
            guess = Integer.parseInt(name.nextLine());
        }
    }
}
