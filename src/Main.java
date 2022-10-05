import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Musician> musicians = new ArrayList<>();

    public static void main(String[] args) {
        menu("Pick a number between 1-3.\nChoice 1: Add a Band\nChoice 2: Add a Musician\nChoice 3: Add a Album");
    }

    public static void menu(String menuDisplay) {
        Scanner in = new Scanner(System.in);
        String menu;
        System.out.println(menuDisplay);

        switch (in.nextLine()) {
            case "1" -> {
                System.out.println("You picked to add a Band");

            }
            //Band;
            case "2" -> {
                System.out.println("You picked to add a Musician. Great!");
                System.out.println("Now pick the musicians first name:");
                String firstName = in.nextLine();
                System.out.println("Pick the musician last name:");
                String lastName = in.nextLine();
                System.out.println("Wich year is/was the musician born?:");
                String dateOfBirth = in.nextLine();
                System.out.println("Wich year did the musician die? (Optional):");
                String dateOfDeath = in.nextLine();
                System.out.println("Info about the musician:");
                String infoText = in.nextLine();
                System.out.println("Wich instrument does the musician use? answer:");
                String instrument = in.nextLine();
                Musician userCreateMusician = new Musician(firstName, lastName, dateOfBirth, dateOfDeath, infoText, instrument);
                musicians.add(userCreateMusician);
                System.out.println(userCreateMusician + "\n");
                System.out.println("Choose between the following alternatives:\n 1. Add another musician.\n 2. Show existing musicians.");
                switch (in.nextLine()) {
                    case "1" -> {

                    }
                    case "2" -> {

                    }
                    case "3" -> {

                    }
                }


                System.out.println(musicians);

//_____________________________________________________________________________________________
                //nested case: add another musician
                // System.out.println("Add another musician\n");
                //userCreateMusician.addMusician(userCreateMusician);

                //nested case: show musician list
                //   userCreateMusician.showMusicianList();
                System.out.println();
                //nested case: search MusicianByName
                //   userCreateMusician.searchMusicianByName(userCreateMusician.firstName, userCreateMusician.lastName);
                //nested case: remove musician by name
                // userCreateMusician.removeMusicianByName(userCreateMusician.getFirstName());
                System.out.println();
                //    userCreateMusician.showMusicianList();

                //Ta inte bort
//______________________________________________________________________________________________


              /*  switch (parsedMenuNumber){
                System.out.println("Pick between one of the following\n1. Add another musician");
                    case "add" -> System.out.println("add new musician");
                    break;
                    case "remove" -> System.out.println("remove existing an existing musician");
                    break;
                    case "all" -> System.out.println("show all existing musicians");
                    default -> System.out.println("Pick one of the following numbers!");
                } */
                //Musician;
            }
            case "3" -> System.out.println("You picked to add a Album");


            //Album;
            default -> menu("Not a valid input");
        }
    }
}