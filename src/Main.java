import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu("Pick a number between 1-3.\nChoice 1: Add a Band\nChoice 2: Add a Musician\nChoice 3: Add a Album");
    }
    public static void menu(String menydisplay){
        Scanner in = new Scanner(System.in);
        String menu;
        System.out.println(menydisplay);
        menu = in.nextLine();
        int menuNumber = 0;
        try {
            menuNumber = Integer.parseInt(menu);
        } catch (Exception ignore){
            System.out.println("That was not a number");
        }
        int parsedmenuNumber = menuNumber;
        switch (parsedmenuNumber) {
            case 1 -> System.out.println("You picked to add a Band");

            //Band;
            case 2 -> System.out.println("You picked to add a Musician");

            //Musician;
            case 3 -> System.out.println("You picked to add a Album");

            //Album;
            default -> menu("Not a valid input");
        }
    }
}