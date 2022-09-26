import java.util.ArrayList;
import java.util.Scanner;

public class Musician {
Scanner in = new Scanner(System.in);
    // Fields specific to musicians
    public String firstName;
    public String lastName;

    public String infoText;
    public int dateOfBirth;
    public String instrument;
    public ArrayList<Band> bands = new ArrayList<>();

    // Constructor
    public Musician(String firstName, String lastName, String infoText, int dateOfBirth, String instrument){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.infoText = infoText;
        this.instrument = instrument;
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
