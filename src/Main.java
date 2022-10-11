import java.util.ArrayList;

public class Main {
    static ArrayList<Musician> musicians = new ArrayList<>();
    static ArrayList<Band> bands = new ArrayList<>();
    public static void main(String[] args) {
        while (true) { //Display menu while true.
            Menu.menu("Pick an option!\n1. Add a Band.\n2. Show all bands.\n3. Delete an already existing band.\n4. Add a musician.\n5. Show all musicians.\n6. Delete an already existing musician..\n7. Quit: Exit the program by entering the word 'quit'.");
        }
    }
}