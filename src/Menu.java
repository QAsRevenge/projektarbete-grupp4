import java.util.Scanner;

public class Menu {

    public static void menu() {
        subMenu(Input.menu("----- Welcome to your library! -----\nPick a category below:", "Band", "Album", "Musician", "Save", "Exit"));
    }

    public static void subMenu(String mainChoice) {
        switch (mainChoice) {
            case "Band" ->
                    subMenuChoices(Input.menu("What would you like to do?", "Add a band", "Remove a band", "Add a musician to a band", "Remove a musician from a band", "Add an album to a band", "Remove an album from a band", "Display current list of bands"), "Band");
            case "Album" ->
                    subMenuChoices(Input.menu("What would you like to do?", "Add an album", "Remove an album", "Add a musician to an album", "Remove a musician from an album", "Display current list of albums"), "Album");
            case "Musician" ->
                    subMenuChoices(Input.menu("What would you like to do?", "Add a musician", "Remove a musician", "Add a musician to a band", "Remove a musician from a band", "Add an album to a musician", "Remove an album from a musician", "Display current list of musicians"), "Musician");
            case "Save" -> {
                ItemStore.save("data.json");
                System.out.println("Your library has been saved, returning to the main menu.");
                Input.sleep(2000);
                menu();
            }
            case "Exit" -> {
                System.exit(1337);
            }
            default -> menu();
        }
    }


    public static void subMenuChoices(String subChoice, String mainChoice) {
        Scanner in = new Scanner(System.in);
        switch (mainChoice) {
            case "Band" -> {
                switch (subChoice) {
                    case "Add a band": {
                        Input.print("Enter the bands name");
                        String bandName = in.nextLine();
                        Input.print("Enter information about the band:");
                        String infoText = in.nextLine();
                        Input.print("Which year did the band form?");
                        String yearOfFormation = in.nextLine();
                        Input.print("Which year did the band disband? If they have not disbanded yet, press enter.");
                        String yearOfDisband = in.nextLine();
                        new Band(bandName, infoText, yearOfFormation, yearOfDisband);
                        Input.print(bandName + " has been added.");
                        menu();
                    }
                    case "Remove a band": {
                        Input.print("Would you like to see the current list of bands in the library?\n Enter Y/N.");
                        String yesOrNo = in.nextLine();
                        if (yesOrNo.equals("Y") && ItemStore.lists.bands.isEmpty()) {
                            Input.print("The list is currently empty.\n\n");
                            Input.print("Go back to the main menu? Enter Y to go back, N to exit the program.");
                            String yesOrNoAgain = in.nextLine();
                            if (yesOrNoAgain.equals("Y"))
                                menu();
                            else {
                                System.exit(2);
                            }
                        } else if (yesOrNo.equals("Y")) {
                            Input.print("------ Your current list of bands ------");
                            Band.showAllBands();
                            Input.print("Enter the name of the band you would like to remove");
                            String bandToRemove = in.nextLine();
                            for (int i = ItemStore.lists.bands.size() - 1; i >= 0; i--) {
                                if (ItemStore.lists.bands.get(i).getBandName().equals(bandToRemove)) {
                                    ItemStore.lists.bands.remove(i);
                                    Input.print(bandToRemove + " has been removed.");
                                    menu();
                                }
                            }
                        } else if (yesOrNo.equals("N")) {
                            Input.print("Enter the name of the band you would like to remove");
                            String bandToRemove = in.nextLine();
                            for (int y = ItemStore.lists.bands.size() - 1; y >= 0; y--) {
                                if (ItemStore.lists.bands.get(y).getBandName().equals(bandToRemove)) {
                                    ItemStore.lists.bands.remove(y);
                                    Input.print(bandToRemove + " has been removed");
                                    menu();
                                }
                            }
                        }
                    }
                    case "Add a musician to a band": {
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to add a musician to?");
                        Band bandToAdd = Band.checkBands(in.nextLine());
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to add to the band?");
                        Musician musicianToAdd = Musician.checkMusicians(in.nextLine());
                        assert bandToAdd != null;
                        bandToAdd.addMusicianToBand(bandToAdd, musicianToAdd);
                        assert musicianToAdd != null;
                        Input.print(musicianToAdd.getName() + " has been added to " + bandToAdd.getBandName());
                        menu();
                    }
                    case "Remove a musician from a band": {
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to remove a musician from?");
                        Band band = Band.checkBands(in.nextLine());
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to remove from the band?");
                        Musician musicianToRemove = Musician.checkMusicians(in.nextLine());
                        assert band != null;
                        band.removeMusicianFromBand(musicianToRemove, band);
                        assert musicianToRemove != null;
                        Input.print(musicianToRemove.getName() + " has been removed from " + band.getBandName());
                        menu();
                    }
                    case "Add an album to a band": {
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to add an album to?");
                        Band band = Band.checkBands(in.nextLine());
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to add to the band?");
                        Album album = Album.checkAlbums(in.nextLine());
                        assert band != null;
                        band.addBandToAlbum(band, album);
                        assert album != null;
                        Input.print(album.getAlbumName() + " has been added to " + band.getBandName());
                        menu();
                    }
                    case "Remove an album from a band": {
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to remove an album from?");
                        Band band = Band.checkBands(in.nextLine());
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to remove from the band?");
                        Album album = Album.checkAlbums(in.nextLine());
                        assert band != null;
                        band.removeBandFromAlbum(band, album);
                        assert album != null;
                        Input.print(album.getAlbumName() + " has been removed from " + band.getBandName());
                        menu();
                    }
                    case "Display current list of bands": {
                        Band.showAllBands();
                        Input.print("Would you like to see more information about a band? Enter the bands name: ");
                        Band bandToDisplay = Band.checkBands(in.nextLine());
                        if (bandToDisplay == null) {
                            Input.print("That band does not exist.");
                            menu();
                        } else Band.showBand(bandToDisplay);
                        menu();
                    }
                }
            }

            case "Musician" -> {
                switch (subChoice) {
                    case "Add a musician": {
                        Input.print("Enter the musicians name: ");
                        String name = in.nextLine();
                        Input.print("Enter information about the musician: ");
                        String infoText = in.nextLine();
                        Input.print("What instrument does/did the musician play?");
                        String instrument = in.nextLine();
                        Input.print("What year was the musician born? (YYYY)");
                        Integer dateOfBirth = in.nextInt();
                        new Musician(name, dateOfBirth, infoText, instrument);
                        Input.print(name + " has been added.");
                        menu();
                    }
                    case "Remove a musician": {
                        Input.print("Would you like to see the current list of musicians in the library?\n Enter Y/N.");
                        String yesOrNo = in.nextLine();
                        if (yesOrNo.equals("Y") && ItemStore.lists.musicians.isEmpty()) {
                            Input.print("The list is currently empty.\n");
                            Input.print("Go back to the main menu? Enter Y to go back, N to exit the program.");
                            String yesOrNoAgain = in.nextLine();
                            if (yesOrNoAgain.equals("Y"))
                                menu();
                            else {
                                System.exit(2);
                            }
                        } else if (yesOrNo.equals("Y")) {
                            Musician.showAllMusicians();
                            Input.print("Enter the name of the musician you would like to remove");
                            String musicianToRemove = in.nextLine();
                            {
                                for (int i = ItemStore.lists.musicians.size() - 1; i >= 0; i--) {
                                    if (ItemStore.lists.musicians.get(i).getName().equals(musicianToRemove)) {
                                        ItemStore.lists.musicians.remove(i);
                                        Input.print(musicianToRemove + " has been removed.");
                                        menu();
                                    }
                                }
                            }
                        } else if (yesOrNo.equals("N")) {
                            Input.print("Enter the name of the musician you would like to remove");
                            String musicianToRemove = in.nextLine();
                            {
                                for (int y = ItemStore.lists.musicians.size() - 1; y >= 0; y--) {
                                    if (ItemStore.lists.musicians.get(y).getName().equals(musicianToRemove)) {
                                        ItemStore.lists.musicians.remove(y);
                                        Input.print(musicianToRemove + " has been removed");
                                        menu();
                                    }
                                }
                            }
                        }
                    }
                    case "Add a musician to a band": {
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to add a band to?");
                        Musician musicianToAdd = Musician.checkMusicians(in.nextLine());
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to add to the musician?");
                        Band bandToAdd = Band.checkBands(in.nextLine());
                        assert musicianToAdd != null;
                        musicianToAdd.addBandToMusician(musicianToAdd, bandToAdd);
                        assert bandToAdd != null;
                        Input.print(musicianToAdd.getName() + " has been added to " + bandToAdd.getBandName());
                        menu();
                    }
                    case "Remove a musician from a band": {
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to remove a band from?");
                        Musician musicianToRemove = Musician.checkMusicians(in.nextLine());
                        Input.print("------ Your current list of bands ------");
                        Band.showAllBands();
                        Input.print("Which band would you like to remove from the musician?");
                        Band bandToRemove = Band.checkBands(in.nextLine());
                        assert musicianToRemove != null;
                        musicianToRemove.removeBandFromMusician(musicianToRemove, bandToRemove);
                        menu();
                    }
                    case "Add an album to a musician": {
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to add an album to?");
                        Musician musicianToAdd = Musician.checkMusicians(in.nextLine());
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to add to the band?");
                        Album albumToAdd = Album.checkAlbums(in.nextLine());
                        assert musicianToAdd != null;
                        musicianToAdd.addAlbumToMusician(musicianToAdd, albumToAdd);
                        menu();
                    }
                    case "Remove an album from a musician": {
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to remove an album from?");
                        Musician musicianToRemove = Musician.checkMusicians(in.nextLine());
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to remove from the musician?");
                        Album albumToRemove = Album.checkAlbums(in.nextLine());
                        assert musicianToRemove != null;
                        musicianToRemove.removeAlbumFromMusician(musicianToRemove, albumToRemove);
                        assert albumToRemove != null;
                        Input.print(albumToRemove.getAlbumName() + " has been removed from " + musicianToRemove.getName());
                        menu();
                    }
                    case "Display current list of musicians": {
                        Musician.showAllMusicians();
                        Input.print("\n");
                        Input.print("Would you like to see more information about a musician? Enter the musicians name: ");
                        Musician musicianToDisplay = Musician.checkMusicians(in.nextLine());
                        if (musicianToDisplay == null) {
                            Input.print("That musician does not exist.");
                            menu();
                        } else Musician.showMusician(musicianToDisplay);
                        menu();
                    }
                }
            }
            case "Album" -> {
                switch (subChoice) {
                    case "Add an album": {
                        Input.print("Enter the album name");
                        String albumName = in.nextLine();
                        Input.print("Enter information about the album: ");
                        String infoText = in.nextLine();
                        Input.print("Which year did the album release?");
                        int yearOfRelease = in.nextInt();
                        new Album(albumName, infoText, yearOfRelease);
                        Input.print(albumName + " has been added.");
                        menu();
                    }
                    case "Remove an album": {
                        Input.print("Would you like to see the current list of albums in the library?\n Enter Y/N.");
                        String yesOrNo = in.nextLine();
                        if (yesOrNo.equals("Y") && ItemStore.lists.albums.isEmpty()) {
                            Input.print("The list is currently empty.\n\n");
                            Input.print("Go back to the main menu? Enter Y to go back, N to exit the program.");
                            String yesOrNoAgain = in.nextLine();
                            if (yesOrNoAgain.equals("Y"))
                                menu();
                            else {
                                System.exit(2);
                            }
                        } else if (yesOrNo.equals("Y")) {
                            Input.print("------ Your current list of album ------");
                            Album.showAllAlbums();
                            Input.print("Enter the name of the album you would like to remove");
                            String albumToRemove = in.nextLine();
                            {
                                for (int i = ItemStore.lists.albums.size() - 1; i >= 0; i--) {
                                    if (ItemStore.lists.albums.get(i).getAlbumName().equals(albumToRemove)) {
                                        ItemStore.lists.albums.remove(i);
                                        Input.print(albumToRemove + " has been removed.");
                                        menu();
                                    }
                                }
                            }
                        } else if (yesOrNo.equals("N")) {
                            Input.print("Enter the name of the album you would like to remove");
                            String albumToRemove = in.nextLine();
                            {
                                for (int y = ItemStore.lists.albums.size() - 1; y >= 0; y--) {
                                    if (ItemStore.lists.albums.get(y).getAlbumName().equals(albumToRemove)) {
                                        ItemStore.lists.albums.remove(y);
                                        Input.print(albumToRemove + " has been removed");
                                        menu();
                                    }
                                }
                            }
                        }
                    }
                    case "Add a solo album to a musician": {
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to add a solo album to?");
                        Musician musicianToAdd = Musician.checkMusicians(in.nextLine());
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to add to the musician?");
                        Album albumToAdd = Album.checkAlbums(in.nextLine());
                        assert albumToAdd != null;
                        assert musicianToAdd != null;
                        albumToAdd.addSoloAlbumToMusician(albumToAdd, musicianToAdd);
                        menu();
                    }
                    case "Remove a solo album from a musician": {
                        Input.print("------ Your current list of albums ------");
                        Album.showAllAlbums();
                        Input.print("Which album would you like to remove from a musician?");
                        Album albumToRemove = Album.checkAlbums(in.nextLine());
                        Input.print("------ Your current list of musicians ------");
                        Musician.showAllMusicians();
                        Input.print("Which musician would you like to remove from the album?");
                        Musician musicianToRemove = Musician.checkMusicians(in.nextLine());
                        assert albumToRemove != null;
                        assert musicianToRemove != null;
                        albumToRemove.removeSoloAlbumFromMusician(albumToRemove, musicianToRemove);
                        menu();
                    }

                    case "Display current list of albums": {
                        Album.showAllAlbums();
                        Input.print("\n");
                        Input.print("Would you like to see more information about an album? Enter the albums name: ");
                        Album albumToDisplay = Album.checkAlbums(in.nextLine());
                        if (albumToDisplay == null) {
                            Input.print("That band does not exist.");
                            menu();
                        } else Album.showAlbum(albumToDisplay);
                        menu();
                    }
                }
            }
        }
    }
}























