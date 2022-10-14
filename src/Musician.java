import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Musician extends Item{

    // Fields specific to musicians
    public String name;
    public String infoText;
    public Integer dateOfBirth;
    public String instrument;
    public String yearJoined;

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();

    public String getName() {
        return name;
    }

    // Constructor
    public Musician (String name, Integer dateOfBirth, String infoText, String instrument){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.infoText = infoText;
        this.instrument = instrument;
        ItemStore.add(this);

    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }
    public String getInstrument() {
        return instrument;
    }
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void addBandToMusician (Musician musician, Band bandToAdd){
        if (!musician.getBands().contains(bandToAdd)) {
            musician.addBand(bandToAdd);
            bandToAdd.addMusician(musician);
        }
    }

    public void removeBandFromMusician(Musician musician, Band bandToRemove){
        if (musician.getBands().contains(bandToRemove)){
            bandToRemove.removeMusician(musician);
            musician.removeBand(bandToRemove);
        }
    }

    public void addAlbumToMusician(Musician musician, Album albumToAdd){
        if (!musician.getAlbums().contains(albumToAdd)) {
            musician.addAlbum(albumToAdd);
            albumToAdd.addMusician(musician);
        }
    }

    public void removeAlbumFromMusician(Musician musician, Album albumToRemove){
        if (musician.getAlbums().contains(albumToRemove)){
            musician.removeAlbum(albumToRemove);
            albumToRemove.removeMusician(musician);
        }
    }

    public void addBand (Band bandToAdd){
        if (!bands.contains(bandToAdd)) {
            bands.add(bandToAdd);
        }
    }
    public void removeBand (Band bandToRemove){
        if (bands.contains(bandToRemove)){
            bands.remove(bandToRemove);
        }
        else {
            Input.print("That band is not in the list.");
        }
    }

    public void addAlbum (Album albumToAdd){
        if (!albums.contains(albumToAdd)){
            albums.add(albumToAdd);
        }
    }

    public void removeAlbum (Album albumToRemove){
        if (albums.contains(albumToRemove)){
            albums.remove(albumToRemove);
        }
        else {
            Input.print("That album is not in the list.");
        }
    }
    public int age (int dateOfBirth){
        return 2022 - dateOfBirth;
    }



    public static void showAllMusicians() {
        StringBuilder showMusicians = new StringBuilder();
        int number = 1;
        for (Musician musician : ItemStore.lists.musicians) {
            showMusicians.append(number);
            showMusicians.append(". ");
            showMusicians.append(musician.getName());
            showMusicians.append("\n");
            number++;
        }
        System.out.println(showMusicians);
    }

    public void leaveBand(Band bandToLeave){
        bands.remove(bandToLeave);
        if (bandToLeave.musicians.contains(this)){
            bandToLeave.removeMusicianFromBand(this, bandToLeave);
        }

    }

    public static void showMusician(Musician musicianToShow){
        StringBuilder showMusicianInfo = new StringBuilder();
        showMusicianInfo.append("Musicians name: ");
        showMusicianInfo.append(musicianToShow.getName());
        showMusicianInfo.append("\n");
        showMusicianInfo.append("Information about the musician: ");
        showMusicianInfo.append(musicianToShow.getInfoText());
        showMusicianInfo.append("\n");
        showMusicianInfo.append("Age: ");
        showMusicianInfo.append(musicianToShow.age(musicianToShow.dateOfBirth));
        showMusicianInfo.append("\n");
        showMusicianInfo.append("Instrument: ");
        showMusicianInfo.append(musicianToShow.getInstrument());
        showMusicianInfo.append("\n");
        if (!musicianToShow.bands.isEmpty()) {
            Input.print(musicianToShow.bands);
            showMusicianInfo.append("Bands the musician is in: ");
            musicianToShow.bands.forEach(band -> {
                showMusicianInfo.append(band.getBandName());
            });
            showMusicianInfo.append("\n");
        }
        showMusicianInfo.append("The musicians albums: ");
        if (!musicianToShow.albums.isEmpty()) {
            for (Album album : musicianToShow.albums) {
                showMusicianInfo.append(album.getAlbumName());
                showMusicianInfo.append("\n");
            }
        }
        else {
            showMusicianInfo.append("The musician has no albums");
            showMusicianInfo.append("\n");
        }
        showMusicianInfo.append("\n");
        Input.print(showMusicianInfo);
    }


    public static Musician checkMusicians(String musicianName) {
        for (Musician musician : ItemStore.lists.musicians) {
            if (musician.getName().equalsIgnoreCase(musicianName)) {
                return musician;
            }
        }
        return null;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
    public ArrayList<Band> getBands() {
        return bands;
    }

}
