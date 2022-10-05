

import java.util.ArrayList;
import java.util.Scanner;

public class Band {

    private String bandName;
    private String infoText;
    private String yearOfFormation;
    private String yearOfDisband;

    public ArrayList<Musician> musicians = new ArrayList<>();

    public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Band> bands = new ArrayList<>();

    //Field variables for Band. musician and album can inherit from this class (a band HAS a musician(s), HAS an album(s))

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getYearOfFormation() {
        return yearOfFormation;
    }

    public void setYearOfFormation(String yearOfFormation) {
        this.yearOfFormation = yearOfFormation;
    }

    public String getYearOfDisband() {
        return yearOfDisband;
    }

    public void setYearOfDisband(String yearOfDisband) {
        this.yearOfDisband = yearOfDisband;
    }

    public Band(String bandName, String infoText, String yearOfFormation, String yearOfDisband) {
        this.bandName = bandName;
        this.infoText = infoText;
        this.yearOfFormation = yearOfFormation;
        this.yearOfDisband = yearOfDisband;
    }

    public void addBand(Band bandToAdd) {
        if (!bandToAdd.bands.contains(this)) {
            bandToAdd.addBand(this);
        }
        if (!bands.contains(bandToAdd)) {
            bands.add(bandToAdd);
        }
    }

    public void addBandToAlbum(Album albumToAdd) {
        if (!albumToAdd.bands.contains(this)) {
            albumToAdd.addAlbumToBand(this);
        }
        if (!albums.contains(albumToAdd)) {
            albums.add(albumToAdd);
        }
    }

    public void removeBand(Band bandToRemove) {
        if (bandToRemove.bands.contains(this)) {
            bandToRemove.removeBand(this);
        }
        bands.remove(bandToRemove);
    }

    public void addMusicianToBand(Musician musicianToAdd) {
        if (!musicianToAdd.bands.contains(this)) {
            musicianToAdd.joinBand(this);
        }
        if (!musicians.contains(musicianToAdd)) {
            musicians.add(musicianToAdd);
        }
    }

    public void removeMusicianFromBand(Musician musicianToRemove) {
        if (musicianToRemove.bands.contains(this)) {
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
    public String toString() {
        StringBuilder info = new StringBuilder("Band: " + bandName + "Info: " + infoText + "Years active: " + yearOfFormation + "-" + yearOfDisband);
        for (Band band : bands) {
            info.append(band.toString());
            info.append(", ");
        }
        return info.toString();
    }
}

