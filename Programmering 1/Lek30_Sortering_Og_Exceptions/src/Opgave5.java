import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {
        File filein = new File("eksempel.txt");
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) {
                numbers.add(scan.nextInt());
            }
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = numbers.size()-1; i >= 0; i--) {
            System.out.println(numbers.get(i));
        }
    }
}
