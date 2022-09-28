import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;

public class Band extends Item {

    //Field variables for Band. musician and album can inherit from this class (a band HAS a musician(s), HAS an album(s))
    private String bandName;
    private String infoText;
    private String yearOfFormation;
    private String yearOfDisband;


    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Musician> musicians = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albums = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();

    public Band (String bandName, String infoText, String yearOfFormation, String yearOfDisband){
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
        ItemStore.add(this);
    }

    public void addBand(Band bandToAdd){
        if (!bandToAdd.bands.contains(this)){
            bandToAdd.addBand(this);
        }
        if (!bands.contains(bandToAdd)){
            bands.add(bandToAdd);
        }
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

