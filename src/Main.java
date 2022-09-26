

public class Main {
    public static void main(String[] args) {


        Band abba = new Band("ABBA\n","Great swedish group!\n", 1972, "..."  );
        Musician bennyAndersson = new Musician("Benny", "Andersson",
                "Göran Bror Benny Andersson, är en svensk låtskrivare och musiker född i Stockholm",1946
                , "Piano/Keyboard");

        bennyAndersson.joinBand(abba);
        abba.addMusician(bennyAndersson);
        System.out.println(abba);
        System.out.println(bennyAndersson);

    }
}
