import java.util.ArrayList;

public class Album {
    public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Band> bands = new ArrayList<>();
    public ArrayList<Album> albumList = new ArrayList<>();

    // Add field and method for solo albums?
    // Album can have a single musician or a whole band
    public String albumName;
    public String infoText;
    public String yearOfRelease;

    public String toString(){
        StringBuilder about = new StringBuilder("Album: " + albumName + infoText + yearOfRelease);
        return  about + "";
    }
    public Album(String albumName, String infoText, String yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
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



}



