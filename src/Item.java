public class Item {
  public String id;

  @Override
  public String toString(){
    return ItemStore.log(this);
  }

}
