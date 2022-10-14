import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;

public class Band extends Item {
    private final String bandName;
    private final String infoText;
    private final String yearOfFormation;
    private final String yearOfDisband;
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> pastMusicians = new ArrayList<>();


    public Band(String bandName, String infoText, String yearOfFormation, String yearOfDisband) {
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
        ItemStore.add(this); // adds the Musician to ItemStore.lists.musicians
    }

    public void addAlbum(Album addAlbum) {
        if (!albums.contains(addAlbum)) {
            albums.add(addAlbum);
            System.out.println("The album " + addAlbum + " has been added.");
        }
    }

    public void removeAlbum(Album removeAlbum) {
        if (albums.contains(removeAlbum)) {
            albums.remove(removeAlbum);
            System.out.println("The album " + removeAlbum + " has been removed.");
        }
    }

    //Musician joins band. //DO NOT MODIFY THIS METHOD BELOW! If you mess it up its on you.
    public void addMusician(Musician musician) {
        if (!musician.bands.contains(this)) {
            musician.joinBand(this);
        }
        if (!musicians.contains(musician)) {
            musicians.add(musician);
            System.out.println("The musician " + musician + " has been added.");
        }
    }//DO NOT MODIFY OVER THIS LINE!

    public void addBandToAlbum(Band band, Album albumToAdd) {
        if (!getAlbums().contains(albumToAdd)) {
            band.addAlbum(albumToAdd);
            System.out.println("The album " + albumToAdd + " has been added to the band " + band);
        }
        if (!albums.contains(albumToAdd)) {
            // albumToAdd.band = this;
            albums.add(albumToAdd);
        }
    }

    //Musician removed from band. //DO NOT MODIFY THIS METHOD BELOW! If you mess it up its on you.
    public void removeMusician(Musician musician) {
        if (musician.bands.contains(this)) {
            musician.leaveBand(this);
        }
    }

    @Override
    public String toString() {
        return "\nBand name: " + bandName + "\nInfo about the band: " + infoText + "\nDate of formation: " + yearOfFormation + "\nDate of disband (optional): " + yearOfDisband;
    }

    public String getBandName() {
        return bandName;
    }
    public ArrayList<Album> getAlbums() {
        return albums;
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

    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
}