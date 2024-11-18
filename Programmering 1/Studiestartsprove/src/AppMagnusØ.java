import java.util.Scanner;

public class AppMagnusØ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hvor mange kilometer har du fra hjem til EAAA? ");
        int kilometer = scan.nextInt();
        System.out.println("Hvor mange gange har du cyklet til skolen i perioden? ");
        int antalCykelTure = scan.nextInt();
        int samletKilometer = 2 * kilometer * antalCykelTure;

        if (samletKilometer < 100) {
            System.out.println("Lavt");
        }
        else if (samletKilometer < 401) {
            System.out.println("Mellem");
        }
        else {
            System.out.println("Højt");
        }
    }
}
