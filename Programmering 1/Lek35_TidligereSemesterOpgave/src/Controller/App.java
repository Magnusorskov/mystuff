package Controller;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        System.out.println(Storage.Storage.getSalg());
        Controller.salgTilFil("2023 Semesteropgave test");
    }
}
