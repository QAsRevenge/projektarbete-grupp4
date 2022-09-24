public class Main {
    public static void main(String[] args) {

        Band abba = new Band("ABBA\n","Great swedish group!\n", 1972, "..."  );
        Musician bennyAndersson = new Musician("Benny", "Andersson", 1964, "Piano/Keyboard");

        bennyAndersson.joinBand(abba);
        abba.addMusician(bennyAndersson);
        System.out.println(abba);

    }
}
