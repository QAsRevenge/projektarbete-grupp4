import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;

public class Musician extends Item{

    // Fields specific to musicians
    public String firstName;
    public String lastName;
    public String dateOfBirth; // YYYY-MM-DD
    public String instrument;

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();

    // Constructor
    public Musician(String firstName, String lastName, String dateOfBirth, String instrument, Band bands){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.instrument = instrument;
        ItemStore.add(this);
    }
    public void joinBand(Band bandToJoin){
        if (!bands.contains(bandToJoin)){
            bands.add(bandToJoin);
        }
        if (!bandToJoin.musicians.contains(this)){
            bandToJoin.addMusician(this);
        }
    }
    public void leaveBand(Band bandToLeave){
        bands.remove(bandToLeave);
        if (bandToLeave.musicians.contains(this)){
            bandToLeave.removeMusician(this);
        }
    }

}
