import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        File filein = new File("eksempel.txt");

        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) {
                int tal = scan.nextInt();
                System.out.println(tal * 2);
            }
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
