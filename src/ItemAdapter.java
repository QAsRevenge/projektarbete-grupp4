import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class ItemAdapter extends TypeAdapter<Item> {

  @Override
  public void write(JsonWriter out, Item item) throws IOException {
    out.beginObject();
    out.name("ref");
    out.value(item.id);
    out.endObject();
  }

  @Override
  public Item read(JsonReader in) throws IOException {
    in.beginObject();
    in.nextName();
    String id = in.nextString();
    String className = id.replaceAll("\\d$", "");
    Item item = ItemStore.getItemFromClassName(className);
    item.id = "ref: " + id;
    in.endObject();
    return item;
  }

}
