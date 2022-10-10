import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Musician> musicians = new ArrayList<>();
    public static void main(String[] args) {
        while (true) { //Display menu while true.
            Menu.menu("(\"Pick a number between 1-3.\nChoice 1: Add a Band.\nChoice 2: Add a Musician.\nChoice 3: Show already existing musicians.\\nChoice 4: Delete an existing musician.\nChoice quit: Exit the program by entering the word 'quit'. Remember to only use lowercases.");
        }
    }
}