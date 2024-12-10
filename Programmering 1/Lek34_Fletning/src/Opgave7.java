import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {
        System.out.println(linFileSearchPerson("personer.txt", "Thomsen"));
    }

    public static String linFileSearchPerson(String fileName, String
            target) {
        boolean found = false;
        String name = "";
        File filein = new File(fileName);
        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext() && !found) {
                int number = scan.nextInt();
                String firstName = scan.next();
                String lastName = scan.next();
                if (lastName.equals(target)) {
                    found = true;
                    name = firstName + " " + lastName;
                }
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }
}

