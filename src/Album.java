public class Album {


    // Add field and method for soloalbums?
    // Album can have a single musician or a whole band
    public String albumName;
    public String infoText;
    public int yearOfRelease;

    public Album(String albumName, String infoText, int yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
    }
}
