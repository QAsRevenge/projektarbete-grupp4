import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Album extends Item {

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> albums = new ArrayList<>();

    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Band> bands = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    public ArrayList<Album> albumList = new ArrayList<>();

    public String albumName;
    public String infoText;
    public int yearOfRelease;


    public String toString(){

        return "\nAlbum: " + albumName + "\nInfo: " + infoText + "\nYear of release: " + yearOfRelease;
    }
    public Album(String albumName, String infoText, Integer yearOfRelease) {
        this.albumName = albumName;
        this.infoText = infoText;
        this.yearOfRelease = yearOfRelease;
        ItemStore.add(this);
    }


    //add album in the List
    public void addAlbum(Album album){
        albumList.add(album);
    }
    public void removeAlbum(Album album){
        albumList.remove(album);
    }
    
    //public void addSoloAlbum(SoloAlbum album){
      //  albumList.add(soloAlbum);
  //  }

   /* public void addAlbumToBand(Band albumToAdd){
        if(!albumToAdd.bands.contains(this)){
            albumToAdd.addBandToAlbum(this);
        }
        if (!albums.contains(albumToAdd)) {
            albums.add(albumToAdd);
    }*/

}/*   public void removeAlbumFromBand(Album albumToRemove){
    if(albumToRemove.bands.contains(this)){
        albumToRemove.removeAlbumFromBand(this);
    }
        albums.remove(albumToRemove);
    }

    public ArrayList<Band> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Band> albums) {
        this.albums = albums;
    }

    public ArrayList<Band> getBands() {
        return bands;
    }

    public void setBands(ArrayList<Band> bands) {
        this.bands = bands;
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(ArrayList<Album> albumList) {
        this.albumList = albumList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getSoloAlbum() {
        return soloAlbum;
    }

    public void setSoloAlbum(String soloAlbum) {
        this.soloAlbum = soloAlbum;
    }
}

*/

