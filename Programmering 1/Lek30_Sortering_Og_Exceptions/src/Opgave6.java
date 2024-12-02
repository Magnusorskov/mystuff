import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave6 {
    public static void main(String[] args) {
        String fileName = "tal.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            for (int n = 1; n < 100; n++) {
                if (n % 2 != 0) {
                    printWriter.println(n);
                }
            }
            printWriter.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
