import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {
        String fileName = "indtasteTal.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            Scanner scan = new Scanner(System.in);
            int tal = -2;

            while (tal != -1) {
                System.out.println("Indtast et tal der er positivt");
                tal = scan.nextInt();
                if (tal > 0) {
                    printWriter.println(tal);
                }
            }

            printWriter.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
