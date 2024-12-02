import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave8 {
    public static void main(String[] args) {
        try {
            System.out.println("max = " + max("tal1.txt"));
            System.out.println("min = " + min("tal1.txt"));
            System.out.println("gennemsnit = " + gennemsnit("tal1.txt"));
        } catch (IOException e) {
            System.out.println("Filen fejler");
        }

    }

    public static int max(String filename) throws IOException {
        File filein = new File(filename);
        int max = Integer.MIN_VALUE;

        Scanner scan = new Scanner(filein);
        while (scan.hasNext()) {
            int next = scan.nextInt();
            if (next > max) {
                max = next;
            }
        }
        scan.close();
        return max;
    }

    public static int min(String fileName) throws IOException {
        File filein = new File(fileName);
        int min = Integer.MAX_VALUE;

        Scanner scan = new Scanner(filein);
        while (scan.hasNext()) {
            int next = scan.nextInt();
            if (next < min) {
                min = next;
            }
        }
        scan.close();
        return min;
    }

    public static double gennemsnit(String fileName) throws IOException {
        File filein = new File(fileName);
        double sum = 0;
        int count = 0;

        Scanner scan = new Scanner(filein);
        while (scan.hasNext()) {
            int tal = scan.nextInt();
            sum += tal;
            count++;
        }
        scan.close();
        return sum / count;
    }
}

