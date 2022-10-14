public class Main extends Item {
    // QAsRevenge = Hampus Molin, satsar på G i programmet, VG i individuell.
    // draginojd = Armin Fazli Khan
    public static void main(String[] args) {
        if (!ItemFileHandler.fileExists("data.json")) {
            ItemStore.save("data.json");
            ItemStore.log();
        } else {
            ItemStore.load("data.json");

        }
        System.out.println("\n".repeat(25));

        Menu.menu();
    }
}








