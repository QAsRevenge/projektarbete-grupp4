import java.util.ArrayList;
import java.util.Scanner;

public class Band {

    //Field variables for Band. musician and album can inherit from this class (a band HAS a musician(s), HAS an album(s))
    public String bandName;
    public String infoText;
    public int yearOfFormation;
    public int yearOfDisband;
    //Unsure about declaring ArrayLists for all classes, I think we need to store all musicians and albums in separate lists that we can then call?
    public ArrayList<Musician> musicians = new ArrayList<>();
    public ArrayList<Album> albums = new ArrayList<>();


    public Band (String bandName, String infoText, int yearOfFormation, int yearOfDisband){
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
    }
}
