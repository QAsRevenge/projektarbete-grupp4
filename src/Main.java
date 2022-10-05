import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Musician> musicians = new ArrayList<>();

    public static void main(String[] args) {
        while (true) { //Display menu while true.
            menu("Pick a number between 1-3.\nChoice 1: Add a Band\nChoice 2: Add a Musician\nChoice 3: Show already existing musicians");
        }
    }

    public static void menu(String menuDisplay) {
        Scanner in = new Scanner(System.in);
        System.out.println(menuDisplay);

        switch (in.nextLine()) {
            case "1" -> System.out.println("You picked to add a Band");
            //Band;
            case "2" -> {
                System.out.println("You picked to add a Musician. Great!");
                System.out.println("Now pick the musicians first name:");
                String firstName = in.nextLine();
                System.out.println("Pick the musician last name:");
                String lastName = in.nextLine();
                System.out.println("Which year is/was the musician born?:");
                String dateOfBirth = in.nextLine();
                System.out.println("Which year did the musician die? (Optional):");
                String dateOfDeath = in.nextLine();
                System.out.println("Info about the musician:");
                String infoText = in.nextLine();
                System.out.println("Which instrument does the musician use? answer:");
                String instrument = in.nextLine();
                Musician userCreateMusician = new Musician(firstName, lastName, dateOfBirth, dateOfDeath, infoText, instrument);
                musicians.add(userCreateMusician);
                System.out.println(userCreateMusician + "\n");

            }
            case "3" -> System.out.println(musicians);
            case "6" -> System.out.println("You picked to add a Album");

            case "quit" -> System.exit(1);
            //Album;
            default -> menu("Not a valid input");
        }
    }
}