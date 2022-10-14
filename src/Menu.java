import java.util.List;
import java.util.Scanner;

public class Menu extends Item {
    public static void print(String toPrint) {
        System.out.println(toPrint);
    }

    public void menu(String menuDisplay) {
        Scanner in = new Scanner(System.in);
        while (true) {
            print(menuDisplay);
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
                   Band band = new Band(bandName, infoText, yearOfFormation, yearOfDisband);
                    print(bandName + " has been added.");
                        Main.bands.add(band);
                }

                case "2" -> {
                    if (Main.bands.isEmpty())
                        print("There are no bands in the list.");
                    else {
                        System.out.println("List of current bands:\n" + Main.bands);
                    }
                }
                case "3" -> {
                    print("Remove an existing band.\nEnter the bands name.");
                    System.out.println(Main.bands);
                    String bandToRemove = in.nextLine();
                    for (int i = Main.bands.size() - 1; i >= 0; i--) {
                        if (Main.bands.get(i).getBandName().equals(bandToRemove)) {
                            Main.bands.remove(i);
                        }
                    }
                }

                case "4" -> {
                    System.out.printf("%s%n%s%n", "You picked to add a Musician. Great!", "What is the musicians first name?:");
                    String firstName = in.nextLine();
                    print("What is the musicians last name?:");
                    String lastName = in.nextLine();
                    print("Which date was the musician born?:");
                    String dateOfBirth = in.nextLine();
                    print("Which date did the musician die? (Optional):");
                    String dateOfDeath = in.nextLine();
                    print("Info about the musician:");
                    String infoText = in.nextLine();
                    print("Which instrument does the musician use? answer:");
                    String instrument = in.nextLine();
                    Musician userCreateMusician = new Musician(firstName, lastName, infoText, dateOfBirth, dateOfDeath, instrument);
                    Main.musicians.add(userCreateMusician);
                    print(userCreateMusician + "\n");

                }

                case "5" -> print("List of current musicians:" + Main.musicians + "\n");
                case "6" -> {
                    System.out.printf("%s%n%s%n", "Remove on of the current existing musicians.", "\nEnter the musicians first name.");
                    String firstName = in.nextLine();
                    print("Enter the musicians last name.");
                    String lastName = in.nextLine();
                    for (int i = Main.musicians.size() - 1; i >= 0; i--) {
                        if (Main.musicians.get(i).firstName.equals(firstName) && Main.musicians.get(i).lastName.equals(lastName)) {
                            Main.musicians.remove(i);
                        }
                    }
                }
                //Album
                case "7" -> {
                    System.out.println("You picked to add an Album");
                    print("Enter the album name.");
                    String albumName = in.nextLine();
                    print("Info about the album.");
                    String infoText = in.nextLine();
                    print("Which year did the album release?");
                    int yearOfRelease = in.nextInt();
                    Album userCreateAlbum = new Album(albumName, infoText, yearOfRelease);
                    Main.albums.add(userCreateAlbum);
                    print(userCreateAlbum + "\n");
                }
                case "8" -> print("List of current albums:" + Main.albums + "\n");

                case "9" -> {
                    print("Remove one of the current existing albums.\nEnter the albums name.");
                    String albumName = in.nextLine();
                    for (int i = Main.albums.size() - 1; i >= 0; i--) {
                        if (Main.albums.get(i).albumName.equals(albumName)) {
                            Main.albums.remove(i);
                        }
                    }
                }
                /*case "10" -> {
                    ItemStore.save("data.json");
                    ItemStore.log();
                }*/
                case "10" -> {  //DO NOT MODIFY THIS CASE BELOW! If you mess it up its on you.
                    System.out.println("Which band do you want a musician to join?");
                    System.out.println("List: " + Main.bands);
                    Band band = findBand(in.nextLine());
                    if (band == null) {
                        System.out.println("Band could not be found.");
                        continue;
                    }
                    System.out.println("Which musician do you want to join? Name:");
                    Musician musician = findMusician(in.nextLine());
                    if (musician == null) {
                        System.out.println("Musician could not be found.");
                        continue;
                    }
                    band.addMusician(musician);
                    System.out.println(musician.firstName + " has been added to " + band.getBandName());
                }              //DO NOT MODIFY THIS CASE OVER! If you mess it up its on you.

                case "11" -> { //DO NOT MODIFY THIS CASE BELOW! If you mess it up its on you.
                    System.out.println("Which album do you want a musician to join?");
                    System.out.println("List: " + Main.albums);
                    Album album = findAlbum(in.nextLine());
                    if (album == null) {
                        System.out.println("Album could not be found.");
                        continue;
                    }
                    System.out.println("Which musician do you want to join? Name:");
                    Musician musician = findMusician(in.nextLine());
                    if (musician == null) {
                        System.out.println("Musician could not be found.");
                        continue;
                    }
                    album.addMusician(musician);
                    System.out.println(musician.firstName + " has been added to " + album.getFirstName());
                }              //DO NOT MODIFY THIS CASE OVER! If you mess it up its on you.

                case "12" -> { //DO NOT MODIFY THIS CASE OVER! If you mess it up its on you.
                    System.out.println("Which band do you want a musician to get removed from?");
                    System.out.println("List: " + Main.bands);
                    Band band = findBand(in.nextLine());
                    if (band == null) {
                        System.out.println("Band could not be found.");
                        continue;
                    }
                    System.out.println("Which musician do you want to remove? Name:");
                    Musician musician = findMusician(in.nextLine());
                    if (musician == null) {
                        System.out.println("Musician could not be found.");
                        continue;
                    }
                    band.removeMusician(musician);
                    System.out.println(musician.firstName + " has been removed from " + band.getBandName());
                }              //DO NOT MODIFY THIS CASE OVER! If you mess it up its on you.

                case "13" -> { //DO NOT MODIFY THIS CASE BELOW! If you mess it up its on you.
                    System.out.println("Which album do you want a musician to get removed from?");
                    System.out.println("List: " + Main.albums);
                    Album album = findAlbum(in.nextLine());
                    if (album == null) {
                        System.out.println("Album could not be found.");
                        continue;
                    }
                    System.out.println("Which musician do you want to remove? Name:");
                    Musician musician = findMusician(in.nextLine());
                    if (musician == null) {
                        System.out.println("Musician could not be found.");
                        continue;
                    }
                    album.removeMusician(musician);
                    System.out.println(musician.firstName + " has been removed from " + album.getFirstName());
                }           //DO NOT MODIFY THIS CASE OVER! If you mess it up its on you.
                case "14" -> {
                    ItemStore.save("data.json");
                    ItemStore.log();
                }
                case "quit" -> System.exit(1); //Exits the program.

                default -> menu("Not a valid input. Choose an option");
            }
        }
    }
    //find album
    public Album findAlbum(String name) {
        List<Album> albums = ItemStore.getList("Album");
        if (albums!= null){
            for (Album album : albums){
                if ((album.getFirstName().equals(name))) {
                    return album;
                }
            }
        }
        return null;
    }
//find band
    public Band findBand(String name) {
        List<Band> bands = ItemStore.getList("Band");
        if (bands!= null){
            for (Band band : bands){
                if ((band.getBandName().equals(name))) {
                    return band;
                }
            }
        }
        return null;
    }
//find musician
    public Musician findMusician(String name) {
        for (Musician musician : Main.musicians) {
            if ((musician.getFirstName().equals(name))) {
                return musician;
            }
        }
        return null;
    }
}


