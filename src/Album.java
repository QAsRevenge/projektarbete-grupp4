import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;

public class Album extends Item {

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();

    // Add field and method for soloalbums?
    // Album can have a single musician or a whole band
    public String albumName;
    public String infoText;
    public int yearOfRelease;

    public Album(String albumName, String infoText, int yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
        ItemStore.add(this);
    }
}
