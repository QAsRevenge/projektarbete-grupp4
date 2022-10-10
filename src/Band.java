import java.util.ArrayList;

public class Band{
    private final String bandName;
    private final String infoText;
    private final String yearOfFormation;
    private final String yearOfDisband;
    public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Musician> musicians = new ArrayList<>();
    public ArrayList<Musician> pastMusicians = new ArrayList<>();
    public ArrayList<Band> bands = new ArrayList<>();

    public Band(String bandName, String infoText, String yearOfFormation, String yearOfDisband) {
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
    }

    public void addAlbum(Album addAlbum){
        if(!albums.contains(addAlbum)){
            albums.add(addAlbum);
            System.out.println("The album " + addAlbum + " has been added.");
        }
    }

    public void removeAlbum(Album removeAlbum){
        if (albums.contains(removeAlbum)){
            albums.remove(removeAlbum);
            System.out.println("The album " + removeAlbum + " has been removed.");
        }
    }

    public void addMusician(Musician addMusician){
        if(!musicians.contains(addMusician)){
            musicians.add(addMusician);
            System.out.println("The musician " + addMusician + " has been added.");
        }
    }

    public void removeMusician(Musician removeMusician){
        if (musicians.contains(removeMusician)){
            musicians.remove(removeMusician);
            pastMusicians.add(removeMusician);
            System.out.println("The musician " + removeMusician + " has been removed from the band and added to it's past members");
        }
    }


    public void addBandToAlbum(Band band, Album albumToAdd) {
        if (!band.getAlbums().contains(albumToAdd)) {
            band.addAlbum(albumToAdd);
            System.out.println("The album " + albumToAdd + " has been added to the band " + band);
        }
        if (!albums.contains(albumToAdd)) {
            albums.add(albumToAdd);
        }
    }
    public void removeBandFromAlbum(Band band, Album albumToRemove){
        if (band.getAlbums().contains(albumToRemove)){
            band.removeAlbum(albumToRemove);
        }
    }
    public void addMusicianToBand(Band band, Musician musicianToAdd) {
        if (!band.getMusicians().contains(musicianToAdd)) {
            band.addMusician(musicianToAdd);
            System.out.println("The musician " + musicianToAdd + " has been added to the band " + band);
        }
        if (!musicians.contains(musicianToAdd)) {
            musicians.add(musicianToAdd);
        }
    }

    public void removeMusicianFromBand(Musician musicianToRemove, Band band) {
        if (band.getMusicians().contains(musicianToRemove)) {
            musicianToRemove.leaveBand(band);
        }
        musicians.remove(musicianToRemove);
    }
    public void displayBand(Band bandToDisplay){
        print("Band: " + bandToDisplay.bandName);
        print("\n");
        print("Band information: ");
        print(bandToDisplay.infoText);
        print("\n");
        print("Band: ");
        print(bandToDisplay.bandName);
        print("\n");
        print("Band information: ");
        print(bandToDisplay.infoText);
        print("\n");
        print("Year of formation: ");
        print(bandToDisplay.yearOfFormation);
        print("\n");
        if (bandToDisplay.yearOfDisband.equals("")){
            print("Year of disband: ");
            print(bandToDisplay.yearOfDisband);
        }
        print("The bands albums: ");
        for (Album album : bandToDisplay.albums){
            print(album.getAlbumName());
        }
        print("The bands members: ");
        for (Musician musicians : bandToDisplay.musicians){
            print(musicians.getFirstName());
            print(" ");
            print(musicians.getLastName());
            print(" ");
            print(musicians.getInstrument());
        }
        System.out.println(bandToDisplay);
    }

    public String getBandName() {
        return bandName;
    }

    public String getInfoText() {
        return infoText;
    }

    public String getYearOfFormation() {
        return yearOfFormation;
    }

    public String getYearOfDisband() {
        return yearOfDisband;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public ArrayList<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(ArrayList<Musician> musicians) {
        this.musicians = musicians;
    }

    public ArrayList<Musician> getPastMusicians() {
        return pastMusicians;
    }

    public void setPastMusicians(ArrayList<Musician> pastMusicians) {
        this.pastMusicians = pastMusicians;
    }
    public static void print(String toPrint){
        System.out.println(toPrint);
    }
}