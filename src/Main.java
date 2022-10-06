import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void print(String toPrint){
        System.out.println(toPrint);
    }

    static ArrayList<Musician> musicians = new ArrayList<>();

    public static void main(String[] args) {
        while (true) { //Display menu while true.
            menu("Pick a number between 1-3.\nChoice 1: Add a Band.\nChoice 2: Add a Musician.\nChoice 3: Show already existing musicians.\nChoice 4: Delete an existing musician.\nChoice quit: Exit the program by entering the word 'quit'. Remember to only use lowercases.");
        }
    }

    public static void menu(String menuDisplay) {
        Scanner in = new Scanner(System.in);
        System.out.println(menuDisplay);

        switch (in.nextLine()) {
            //band
            case "1" -> {
                System.out.printf("%s%n%s%n", "You picked to add a Band", "What is the band name?");
                String bandName = in.nextLine();
                print("Write some info about the band");
                String infoText = in.nextLine();
                print("Which year did the band form?");
                String yearOfFormation = in.nextLine();
                print("Which year did the band disband? If they have not disbanded yet, press enter");
                String yearOfdDisband = in.nextLine();
                // Probably is a better way to do it but this is what I came up with,
                // thinking of using split to cut out what we want from the input.
                print("Which are the current members of the band, which year did they join and what kind of instrument(s) did they play? \nUse a comma to separate members, year and instruments. End with a dot. \nExample: Gene Simmons, 1973, bass.");
                String currentMembersYearjoinInstruments = in.nextLine();
                print("");
                print("Are there any former members of the band and if so, which year did he/her/they leave? Separate with comma.");
                String formerMembersyearLeft = in.nextLine();
                print("Write the album(s) the band has released. If they are more than one, separate with a comma.");
                String bandAlbum = in.nextLine();
                // Code block not yet done

            }
            //musician
            case "2" -> {
                System.out.printf("%s%n%s%n", "You picked to add a Musician. Great!", "Now pick the musicians first name:");
                String firstName = in.nextLine();
                print("Pick the musician last name:");
                String lastName = in.nextLine();
                print("Which year is/was the musician born?:");
                String dateOfBirth = in.nextLine();
                print("Which year did the musician die? (Optional):");
                String dateOfDeath = in.nextLine();
                print("Info about the musician:");
                String infoText = in.nextLine();
                print("Which instrument does the musician use? answer:");
                String instrument = in.nextLine();
                Musician userCreateMusician = new Musician(firstName, lastName, infoText, dateOfBirth,dateOfDeath , instrument);
                musicians.add(userCreateMusician);
                System.out.println(userCreateMusician + "\n");

            }
            case "3" -> print("List of current musicians:" + musicians + "\n");
            case "4" -> { print("Remove musician, choose between the musicians numbers" + musicians.remove(in.nextLine()));
                for (Musician musician : musicians){
                    if (musician.firstName + musician.lastName == musician.firstName + " " + musician.lastName){
                musicians.remove(in.nextLine());}
            }
            }
            //Album
            case "5" -> print("You picked to add a Album");

            case "quit" -> System.exit(1); //Exits the program.

            default -> menu("Not a valid input. Choose between the following numbers"); //<- sout If not a valid input.
        }
    }
}