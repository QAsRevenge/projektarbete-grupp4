

public class Main {
    public static void main(String[] args) {


        Band abba = new Band("ABBA\n","Great swedish group!\n", 1972, "...\n"  );
        Musician bennyAndersson = new Musician("Benny", "Andersson",
                "Göran Bror Benny Andersson, är en svensk låtskrivare och musiker född i Stockholm", "1946"
                , " ", "Piano/Keyboard");

        bennyAndersson.joinBand(abba);
        abba.addMusician(bennyAndersson);
        System.out.println(abba);


        Musician michaelJackson = new Musician("Michael", "Jackson",
                "Michael Jackson was an American singer, songwriter, dancer, and a philianthropist.\n             " +
                        "       He was also known as the King of Pop.", "1958", "June 25, 2009", "microphone");
        System.out.println(michaelJackson);


    }
}
