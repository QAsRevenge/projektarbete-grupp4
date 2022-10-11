import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Musician> musicians = new ArrayList<>();
    static ArrayList<Band> bands = new ArrayList<>();
    public static void main(String[] args) {
        while (true) { //Display menu while true.
            Menu.menu("(\"Pick a number between 1-3.\nChoice 1: Add a Band.\nChoice 2: Show already existing bands.\nChoice 3: Delete an already existing band.\nChoice 4: Add a musician.\nChoice 5: Show an already existing musician.\nChoice 6: Delete an already existing musician.\nChoice quit: Exit the program by entering the word 'quit'. Remember to only use lowercases.");
        }
    }
}