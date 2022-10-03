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
 public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Musician> musicianList = new ArrayList<>();

    // Constructor
    public Musician (String firstName, String lastName, String infoText, String dateOfBirth, String dateOfDeath, String instrument){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.infoText = infoText;
        this.instrument = instrument;
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
        StringBuilder about = new StringBuilder("Name: " + firstName + lastName + "\nDate of birth: " + dateOfBirth + "\nDate of death: " + dateOfDeath +"\nAbout the musician: " + infoText + "\nInstrument the musician is playing: " + instrument);
        return about + "";
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
