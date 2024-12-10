import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        System.out.println(linFileSearch("talfil.txt",445));
    }

    public static boolean linFileSearch(String fileName, int target) {
        File filein = new File(fileName);
        boolean found = false;

        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext() && !found) {
                if (scan.nextInt() == target) {
                    found = true;
                }
            }
            scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return found;
    }
}
