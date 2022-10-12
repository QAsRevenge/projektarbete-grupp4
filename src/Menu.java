import java.util.Scanner;

public class Menu {
    private static int i;

    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
    public static void menu(String menuDisplay) {
        Scanner in = new Scanner(System.in);
        System.out.println(menuDisplay);

        switch (in.nextLine()) {
            case "1" -> {
                print("You picked to add a band\n");
                print("What is the bands name?");
                String bandName = in.nextLine();
                print("Enter information about the band.");
                String infoText = in.nextLine();
                print("Which year did the band form?");
                String yearOfFormation = in.nextLine();
                print("Which year did the band disband? If they have not disbanded yet, press enter.");
                String yearOfDisband = in.nextLine();
                Band newBand = new Band(bandName, infoText, yearOfFormation, yearOfDisband);
                Main.bands.add(newBand);
                print(bandName + " has been added.");

            }

            case "2" -> {
                System.out.println("List of current bands:\n" + Main.bands);
            }
            case "3" -> {
                print("Remove an existing band.\nEnter the bands name.");
                System.out.println(Main.bands);
                String bandName = in.nextLine();
                for (int i = Main.bands.size() - 1; i >= 0; i--) {
                    if (Main.bands.get(i).bandName.equals(bandName)) {
                        Main.bands.remove(i);
                    }
                }
            }

            case "4" -> {
                System.out.printf("%s%n%s%n", "You picked to add a Musician. Great!", "Now pick the musicians first name:");
                String firstName = in.nextLine();
                print("Pick the musician last name:");
                String lastName = in.nextLine();
                print("Which date was the musician born?:");
                String dateOfBirth = in.nextLine();
                print("Which date did the musician die? (Optional):");
                String dateOfDeath = in.nextLine();
                print("Info about the musician:");
                String infoText = in.nextLine();
                print("Which instrument does the musician use? answer:");
                String instrument = in.nextLine();
                Musician userCreateMusician = new Musician(firstName, lastName, infoText, dateOfBirth, dateOfDeath , instrument);
                Main.musicians.add(userCreateMusician);
                print(userCreateMusician + "\n");

            }

            case "5" -> print("List of current musicians:" + Main.musicians + "\n");
            case "6" -> {
                print("Remove one of the current existing musicians.\nEnter the musicians first name.");
                //print("Enter the musicians first name.");
                String firstName = in.nextLine();
                print("Enter the musicians last name.");
                String lastName = in.nextLine();
                for (int i = Main.musicians.size()-1; i >= 0; i--){
                    if (Main.musicians.get(i).firstName.equals(firstName) && Main.musicians.get(i).lastName.equals(lastName)){
                        Main.musicians.remove(i);
                    }
                }
            }
            //Album
            case "7" -> {
                System.out.println("You picked to add a Album");
                print("Enter the album name.");
                String albumName = in.nextLine();
                print("Info about the album.");
                String infoText = in.nextLine();
                print("Wich year did the album release?");
                int yearOfRelease = in.nextInt();
                Album userCreateAlbum = new Album(albumName, infoText, yearOfRelease);
                Main.albums.add(userCreateAlbum);
                print(userCreateAlbum + "\n");
            }
            case "8" -> print("List of current albums:" + Main.albums + "\n");

            case "9" -> {print("Remove one of the current existing albums.\nEnter the albums name.");
                String albumName = in.nextLine();
                for (int i = Main.albums.size()-1; i >= 0; i--){
                    if (Main.albums.get(i).albumName.equals(albumName)){
                        Main.albums.remove(i);
                    }
                }
            }
            case "quit" -> System.exit(1); //Exits the program.

            default -> menu("Not a valid input. Choose an option");
        }
    }
}
