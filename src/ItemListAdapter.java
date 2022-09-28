import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ItemListAdapter extends TypeAdapter<ArrayList<Item>> {

  @Override
  public void write(JsonWriter out, ArrayList<Item> list) throws IOException {
    out.beginArray();
    for(Item item : list){
      out.beginObject();
      out.name("ref");
      out.value(item.id);
      out.endObject();
    }
    out.endArray();
  }

  @Override
  public ArrayList<Item> read(JsonReader in) throws IOException {
    ArrayList<Item> list = new ArrayList<>();
    in.beginArray();
    while(in.hasNext()){
      in.beginObject();
      in.nextName();
      Item anItem = new Item();
      anItem.id = "ref: " + in.nextString();
      list.add(anItem);
      in.endObject();
    }
    in.endArray();
    return list;
  }

}
