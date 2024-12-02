import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave9b {
    public static void main(String[] args) {
        try {
            firstFiveRanking();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void firstFiveRanking() throws FileNotFoundException {
        int year = 2010;
        ArrayList<String> girls = new ArrayList<>();
        ArrayList<String> boys = new ArrayList<>();
        while (year > 2000) {
            File filein = new File("nameranking" + year + ".txt");
            Scanner scan = new Scanner(filein);
            int rank = 1;
            while (rank != 6 && scan.hasNext()) {
                String line = scan.nextLine();
                Scanner scanLine = new Scanner(line);
                while (scanLine.hasNext()) {
                    String ranking = scanLine.next();
                    String boyName = scanLine.next();
                    String boyNameAmount = scanLine.next();
                    String girlName = scanLine.next();
                    String girlNameAmount = scanLine.next();
                    girls.add(girlName);
                    boys.add(boyName);
                }
                rank++;
            }
            year--;
        }


        System.out.printf("%-8s", "Year");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-12s", "Rank " + (i % 5 + 1));
        }
        int girlIndex = 0;
        int boyIndex = 0;
        for (year = 2010; year > 2000; year--) {
            System.out.printf("\n%-8d", year);
            for (int i = 0; i < 5; i++) {
                System.out.printf("%-12s", girls.get(girlIndex));
                girlIndex++;
            }
            for (int i = 0; i < 5; i++) {
                System.out.printf("%-12s", boys.get(boyIndex));
                boyIndex++;
            }
        }
    }
}
