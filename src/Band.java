import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Band extends Item {
    private String bandName;
    private String infoText;
    private String yearOfFormation;
    private String yearOfDisband;

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<>();


    public Band(String bandName, String infoText, String yearOfFormation, String yearOfDisband) {
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
        ItemStore.add(this);
    }

    public void addAlbum(Album addAlbum) {
        if (!albums.contains(addAlbum)) {
            albums.add(addAlbum);
        }
    }


    public void removeAlbum(Album albumToRemove) {
        albums.remove(albumToRemove);
    }


    public void addMusician(Musician musicianToAdd) {
        if (!musicians.contains(musicianToAdd)) {
            musicians.add(musicianToAdd);
        }
    }

    public void removeMusician(Musician musicianToRemove) {
        musicians.remove(musicianToRemove);
    }



    public void addBandToAlbum(Band band, Album albumToAdd) {
        if (!band.getAlbums().contains(albumToAdd)) {
            band.addAlbum(albumToAdd);
            albumToAdd.addBand(band);
        }
    }

    public void removeBandFromAlbum(Band band, Album albumToRemove) {
        if (band.getAlbums().contains(albumToRemove)) {
            band.removeAlbum(albumToRemove);
            albumToRemove.removeBand(band);
        }
    }

    public void addMusicianToBand(Band band, Musician musicianToAdd) {
        if (!band.getMusicians().contains(musicianToAdd)) {
            band.addMusician(musicianToAdd);
        }
        if (!musicians.contains(musicianToAdd)) {
            musicians.add(musicianToAdd);
        }
    }

    public void removeMusicianFromBand(Musician musicianToRemove, Band band){
        if (band.getMusicians().contains(musicianToRemove)) {
            musicianToRemove.leaveBand(band);
            band.removeMusician(musicianToRemove);
        }
    }


    public static void showBand(Band bandToShow){
        StringBuilder showBandInfo = new StringBuilder();
        showBandInfo.append("Band name: ");
        showBandInfo.append(bandToShow.bandName);
        showBandInfo.append("\n");
        showBandInfo.append("Information about the band: ");
        showBandInfo.append(bandToShow.infoText);
        showBandInfo.append("\n");
        showBandInfo.append("The bands year of formation: ");
        showBandInfo.append(bandToShow.yearOfFormation);
        showBandInfo.append(".");
        showBandInfo.append("\n");
        if (!bandToShow.yearOfDisband.equals("")) {
            showBandInfo.append("The year the band disbanded: ");
            showBandInfo.append(bandToShow.yearOfDisband);
            showBandInfo.append("\n");
        }
        showBandInfo.append("The bands albums: ");
        if (!bandToShow.albums.isEmpty()) {
            for (Album album : bandToShow.albums) {
                showBandInfo.append(album.getAlbumName()).append(", ").append(album.getYearOfRelease()).append(".");
                showBandInfo.append("\n");
            }
        }
        else {
            showBandInfo.append("The band has no albums");
            showBandInfo.append("\n");
        }
        showBandInfo.append("The bands members: ");
        if (!bandToShow.musicians.isEmpty()){
            for (Musician musician : bandToShow.musicians){
                showBandInfo.append(musician.getName()).append("\n").append("Instrument: ").append(musician.getInstrument()).append("\n");
            }
        }
        else {
            showBandInfo.append("The band has no members");
            showBandInfo.append("\n");
        }
        showBandInfo.append("\n");
        Input.print(showBandInfo);
    }
    public static void showAllBands() {
        StringBuilder showBands = new StringBuilder();
        int number = 1;
        for (Band band : ItemStore.lists.bands) {
            showBands.append(number);
            showBands.append(". ");
            showBands.append(band.getBandName());
            showBands.append("\n");
            number++;
        }
        System.out.println(showBands);
    }

    public static Band checkBands(String bandName) {
        for (Band band : ItemStore.lists.bands) {
            if (band.getBandName().equalsIgnoreCase(bandName)) {
                return band;
            }
        }
        return null;
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
}

