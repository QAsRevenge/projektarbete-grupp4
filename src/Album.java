import java.util.ArrayList;

public class Album {
    public ArrayList<Band> albums = new ArrayList<>();
    public ArrayList<Band> bands = new ArrayList<>();
    public ArrayList<Album> albumList = new ArrayList<>();

    // Add field and method for solo albums?
    // Album can have a single musician or a whole band
    public String albumName;
    public String infoText;
    public String yearOfRelease;
    public String soloAlbum;

    public String toString(){
        StringBuilder about = new StringBuilder("Album: " + albumName + infoText + yearOfRelease + soloAlbum);
        return  about + "";
    }
    public Album(String albumName, String infoText, String yearOfRelease, String soloAlbum) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
        this.soloAlbum = soloAlbum;
    }

   /* public void addMusicianToAlbum(String MusicianToAdd){

        if (!MusicianToAdd.album.contains(this)){
            System.out.println("hi");
        }
    }
    */

    //add album in the List
    public void addAlbum(Album album){
    albumList.add(album);
    }
    public void removeAlbum(Album album){
        albumList.remove(album);
    }
    
    public void addSoloAlbum(SoloAlbum album){
        albumList.add(soloAlbum);
    }

    public void addAlbumToBand(Band albumToAdd){
        if(!albumToAdd.bands.contains(this)){
            albumToAdd.addBandToAlbum(this);
        }
        if (!albums.contains(albumToAdd)) {
            albums.add(albumToAdd);
    }

}   public void removeAlbumFromBand(Album albumToRemove){
    if(albumToRemove.bands.contains(this)){
        albumToRemove.removeAlbumFromBand(this);
    }
        albums.remove(albumToRemove);
    }
}



