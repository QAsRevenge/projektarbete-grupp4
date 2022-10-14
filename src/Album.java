import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Album extends Item {


    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<>();
    public String albumName;
    public String infoText;
    public Integer yearOfRelease;


    public Album(String albumName, String infoText, Integer yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
        ItemStore.add(this);
    }

    public void addBand(Band bandToAdd) {
        if (!bands.contains(bandToAdd)) {
            bands.add(bandToAdd);
        }
    }


    public void removeBand(Band bandToRemove) {
        bands.remove(bandToRemove);
    }


    public void addMusician(Musician musicianToAdd) {
        if (!musicians.contains(musicianToAdd)) {
            musicians.add(musicianToAdd);
        }
    }

    public void removeMusician(Musician musicianToRemove) {
        musicians.remove(musicianToRemove);
    }

    public void addSoloAlbumToMusician(Album albumToAdd, Musician musician) {
        if (!musician.getAlbums().contains(albumToAdd)) {
            musician.addAlbum(albumToAdd);
        }
    }

    public void removeSoloAlbumFromMusician(Album albumToRemove, Musician musician) {
        if (musician.getAlbums().contains(albumToRemove)) {
            musician.removeAlbum(albumToRemove);
        }
    }


    public static void showAllAlbums() {
        StringBuilder showAlbums = new StringBuilder();
        int number = 1;
        for (Album album : ItemStore.lists.albums) {
            showAlbums.append(number);
            showAlbums.append(". ");
            showAlbums.append(album.getAlbumName());
            showAlbums.append("\n");
            number++;
        }
        System.out.println(showAlbums);
    }

    public static void showAlbum(Album albumToShow) {
        StringBuilder showAlbumInfo = new StringBuilder();
        showAlbumInfo.append("Album name: ");
        showAlbumInfo.append(albumToShow.getAlbumName());
        showAlbumInfo.append("\n");
        showAlbumInfo.append("Year of release: ");
        showAlbumInfo.append(albumToShow.getYearOfRelease());
        showAlbumInfo.append("\n");
        showAlbumInfo.append("Information about the album: ");
        showAlbumInfo.append(albumToShow.getInfoText());
        showAlbumInfo.append("\n");
        if (!albumToShow.bands.isEmpty()) {
            Input.print(albumToShow.bands);
            showAlbumInfo.append("Band that released the album: ");
            albumToShow.bands.forEach(band -> {
                showAlbumInfo.append(band.getBandName());
            });
            showAlbumInfo.append("\n");
        }
        showAlbumInfo.append("Musicians on the album: ");
        if (!albumToShow.musicians.isEmpty()) {
            for (Musician musician : albumToShow.musicians) {
                showAlbumInfo.append(musician.getName());
                showAlbumInfo.append("\n");
            }
        } else {
            showAlbumInfo.append("The musician has no albums");
            showAlbumInfo.append("\n");
        }
        showAlbumInfo.append("\n");
        Input.print(showAlbumInfo);
    }

    public static Album checkAlbums(String albumName) {
        for (Album album : ItemStore.lists.albums) {
            if (album.getAlbumName().equalsIgnoreCase(albumName)) {
                return album;
            }
        }
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }


    public String getInfoText() {
        return infoText;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }
}




