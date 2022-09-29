import java.util.ArrayList;

public class Musician {
    // Fields specific to musicians
    public String firstName;
    public String lastName;
    public String infoText;
    public String dateOfBirth;
    public String dateOfDeath;
    public String instrument;
    public ArrayList<Band> bands = new ArrayList<>();
public ArrayList<Musician> musicians = new ArrayList<>();



    // Constructor
    public Musician(String firstName, String lastName, String infoText, String dateOfBirth, String dateOfDeath, String instrument){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.infoText = infoText;
        this.instrument = instrument;
    }
    public String toString(){
        StringBuilder about = new StringBuilder("Name: " + firstName + lastName + "\nDate of birth: " + dateOfBirth + "\nDate of death: " + dateOfDeath +"\nAbout the musician: " + infoText + "\nInstrument the musician is playing: " + instrument);
        return about + ""; //+firstName + " " + lastName + ": " + dateOfBirth + ": " +dateOfDeath + ": " + infoText + ": " + instrument;
    }

    public void joinBand(Band bandToJoin){
        if (!bands.contains(bandToJoin)){
            bands.add(bandToJoin);
        }
        if (!bandToJoin.musicians.contains(this)){
            bandToJoin.addMusicianToBand(this);
        }
    }
    public void leaveBand(Band bandToLeave){
        bands.remove(bandToLeave);
        if (bandToLeave.musicians.contains(this)){
            bandToLeave.removeMusicianFromBand(this);
        }
    }

}
