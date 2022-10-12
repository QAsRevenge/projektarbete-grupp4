import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;

public class Main extends Item {
    @JsonAdapter(ItemListAdapter.class)
    static ArrayList<Musician> musicians = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    static ArrayList<Band> bands = new ArrayList<>();
    @JsonAdapter(ItemListAdapter.class)
    static ArrayList<Album> albums = new ArrayList<>();


    public static void main(String[] args) {
        if (!ItemFileHandler.fileExists("data.json")) {
            ItemStore.save("data.json");
            ItemStore.log();
        } else {
            ItemStore.load("data.json");

        }
        ItemStore.log();

        Menu.menu("Pick an option!\n1. Add a Band.\n2. Show all bands.\n3. Delete an already existing band.\n4. Add a musician.\n5. Show all musicians.\n6. Delete an already existing musician.\n7. Add an album.\n8. Show all albums.\n9. Remove an already existing album.\n10. Save.\n Quit: Exit the program by entering the word 'quit'.");

    }
}