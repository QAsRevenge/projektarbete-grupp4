import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Musician extends Item{

    // Fields specific to musicians
    public String firstName;
    public String lastName;
    public String infoText;
    public String dateOfBirth;
    public String dateOfDeath;
    public String instrument;

    // public ArrayList<Band> myBands = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<>();

    // Constructor
    public Musician (String firstName, String lastName, String infoText, String dateOfBirth, String dateOfDeath, String instrument){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.infoText = infoText;
        this.instrument = instrument;
        ItemStore.add(this);
    }
    //getters

    public String getFirstName() {
        return firstName;
    }


    public String toString(){
        return "\nName: " + firstName + " " + lastName + "\nDate of birth: " + dateOfBirth + "\nDate of death: " + dateOfDeath + "\nAbout the musician: " + infoText + "\nInstrument the musician is playing: " + instrument + "\n";
    }

//Musician join band //DO NOT MODIFY THIS METHOD UNDER! If you mess it up its on you.
    public void joinBand(Band bandToJoin){
        if (!bands.contains(bandToJoin)){
            bands.add(bandToJoin);
        }
        if (!bandToJoin.musicians.contains(this)){
            bandToJoin.addMusician(this);
        }
    }
    //Musician join album //DO NOT MODIFY THIS METHOD UNDER! If you mess it up its on you.
    public void joinAlbum(Album albumToJoin){
        if (!albums.contains(albumToJoin)){
            albums.add(albumToJoin);
        }
        if (!albumToJoin.musicians.contains(this)){
            albumToJoin.addMusician(this);
        }
    }
    //Musician leave album //DO NOT MODIFY THIS METHOD UNDER! If you mess it up its on you.
    public void leaveAlbum(Album albumToRemove){
        if (albumToRemove.musicians.contains(this)){
            albumToRemove.removeMusician(this);
        }
        bands.remove(albumToRemove);

    }



//Musician leave band //DO NOT MODIFY THIS METHOD UNDER! If you mess it up its on you.
    public void leaveBand(Band bandToRemove){
       if (bandToRemove.musicians.contains(this)){
        bandToRemove.removeMusician(this);
        }
       bands.remove(bandToRemove);

    }
}


