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
        // code under "cleans" the console at the start but does not fix the
        // problem with the gson file showing all the bands, musicians and albums.
        // Thomas does not like that the gson shows up at the start, If I recall correctly.
        System.out.println("\n".repeat(60));
        new Menu().menu("Pick an option!\n1. Add a Band.\n2. Show all bands.\n3. Delete an already existing band.\n4. Add a musician.\n5. Show all musicians.\n6. Delete an already existing musician.\n7. Add an album.\n8. Show all albums.\n9. Remove an already existing album.\n10. Add a musician to a band.\n11. Add musician to a album.\n12. Remove a musician from a band.\n13. Remove a musician from a album.\n14. Save.\n Quit: Exit the program by entering the word 'quit'.");

    }
}