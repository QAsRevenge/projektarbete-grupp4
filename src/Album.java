import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Album extends Item {

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> albums = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<Musician>();


    public String albumName;
    public String infoText;
    public int yearOfRelease;


    public String toString() {

        return "\nAlbum: " + albumName + "\nInfo: " + infoText + "\nYear of release: " + yearOfRelease;
    }
    //Add musician to album.
    public void addMusician(Musician musician){
        if (!musician.albums.contains(this)){
            musician.joinAlbum(this);
        }
        if(!musicians.contains(musician)){
            musicians.add(musician);
            System.out.println("The musician " + musician + " has been added.");
        }
    }
    //remove musician from album.
    public void removeMusician(Musician musician){
        if (musician.albums.contains(this)){
            musician.leaveAlbum(this);
        }
    }

    public Album(String albumName, String infoText, Integer yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
        ItemStore.add(this);
    }
  // get first name.
    public String getFirstName() {
        return albumName;


    }
}
