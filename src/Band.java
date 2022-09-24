import java.util.ArrayList;
import java.util.Scanner;

public class Band {

    //Field variables for Band. musician and album can inherit from this class (a band HAS a musician(s), HAS an album(s))
    public String bandName;
    public String infoText;
    public int yearOfFormation;
    public String yearOfDisband;
    //Unsure about declaring ArrayLists for all classes, I think we need to store all musicians and albums in separate lists that we can then call?
    public ArrayList<Musician> musicians = new ArrayList<>();
    public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Band> bands = new ArrayList<>();


    public Band (String bandName, String infoText, int yearOfFormation, String yearOfDisband){
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
    }

    public void addMusician(Musician musicianToAdd){
        if (!musicianToAdd.bands.contains(this)){
            musicianToAdd.joinBand(this);
        }
        if (!musicians.contains(musicianToAdd)){
            musicians.add(musicianToAdd);
        }
    }
    public void removeMusician(Musician musicianToRemove){
        if (musicianToRemove.bands.contains(this)){
            musicianToRemove.leaveBand(this);
        }
        musicians.remove(musicianToRemove);
    }

    /* // Wait with this until group discussion regarding how to add soloalbums
       // and "band albums"
    public void addAlbum(Album albumToAdd){
        if (!albumToAdd.bands.contains
*/
    @Override
    public String toString(){
        StringBuilder info = new StringBuilder("Band: " + bandName + "Info: " + infoText + "Years active: " + yearOfFormation + "-" + yearOfDisband );
        for (Band band : bands){
            info.append(band.toString());
            info.append(", ");
        }
        return  info.toString();
    }
    }

