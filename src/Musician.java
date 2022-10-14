import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;
import java.util.Objects;

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
    public ArrayList<Musician> musicianList = new ArrayList<>();

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    //setters and getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
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

    public void addMusician(Musician musician){
        musicianList.add(musician);
    }
    public void removeMusicianByName(String firstName){
        for (Musician musician: musicianList) {
            if (musician.getFirstName() + musician.getLastName() == firstName + " " + lastName){
                musicianList.remove(musician);
            }
        }
        showMusicianList();
    }

    public void musicianAge(){
        // If the dateOfDeath is skipped (as in an empty string)
        // it should go in to the if statement directly below.
        // Otherwise, it should go in to the else statement.
        // Currently, does not show up in the musicians list, needs to be added.
        if (Objects.equals(dateOfDeath, "")){
            int currentYear = 2022;
            int dateOfBirthInt = Integer.parseInt(dateOfBirth);
            int musiciansAge = currentYear - dateOfBirthInt;
            String musiciansAgeString = String.valueOf(musiciansAge);
        } else {
            int dateOfBirthInt = Integer.parseInt(dateOfBirth);
            int dateOfDeathInt = Integer.parseInt(dateOfDeath);
            int musiciansAge = dateOfDeathInt - dateOfBirthInt;
            String musiciansAgeString = String.valueOf(musiciansAge);
        }
    }


    public void searchMusicianByName(String firstName, String lastName){
        for (Musician musician: musicianList){
            if ((musician.getFirstName().equals(firstName + " " + lastName))) {
                System.out.println("Information about: " + musician.getFirstName() );
                System.out.println(musician.getFirstName() + " " + musician.getLastName() + " " + infoText);

            }
        }
    }
    public void showMusicianList(){
        for (Musician musician: musicianList){
    System.out.println(musician.getFirstName() + " " + musician.getLastName() + " " + musician.getDateOfBirth() );
}
    }


    public String toString(){
        return "\nName: " + firstName + " " + lastName + "\nDate of birth: " + dateOfBirth + "\nDate of death: " + dateOfDeath + "\nAbout the musician: " + infoText + "\nInstrument the musician is playing: " + instrument + "\n";
    }

   /* public void joinBand(Band bandToJoin){
        if (!bands.contains(bandToJoin)){
            bands.add(bandToJoin);
        }
        if (!bandToJoin.musicians.contains(this)){
            ArrayList<String>emptyList = new ArrayList<>();
            bandToJoin.addMusicianToBand(this, "1943", emptyList);
        }
    }*/
    /*
    public void leaveBand(Band bandToLeave){
        bands.remove(bandToLeave);
        if (bandToLeave.musicians.contains(this)){
            bandToLeave.removeMusicianFromBand(this, bandToLeave);
        }*/
    }


