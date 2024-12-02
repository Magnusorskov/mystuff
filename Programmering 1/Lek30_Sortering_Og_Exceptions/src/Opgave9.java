import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Year;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Opgave9 {
    public static void main(String[] args) {
        System.out.println("Enter the year (between 2001 and 2010");
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        System.out.println("Enter the name ");
        String name = scan.next();
        System.out.println("Enter the gender with a char (b/f)");
        String genderString = scan.next();
        char gender = genderString.charAt(0);

        try {
            System.out.println("The name " + name + " is ranked number " + babyRanking(year, name, gender) + " in the year " + year);
        } catch (IOException e) {
            System.out.println("Filen findes ikke");
        } catch (NoSuchElementException e) {
            System.out.println("The name " + name + " with the gender " + gender + " is not ranked in year " + year);
        }
    }

    public static int babyRanking(int year, String name, char gender) throws FileNotFoundException {
        File filein = new File("nameranking" + year + ".txt");
        boolean found = false;
        int ranking = -1;
        Scanner scan = new Scanner(filein);

        while (!found && scan.hasNext()) {
            String line = scan.nextLine();
            Scanner scanLine = new Scanner(line);
            while (scanLine.hasNext() && !found) {
                ranking = Integer.parseInt(scan.next());
                String boyName = scan.next();
                String boyNameAmount = scan.next();
                String girlName = scan.next();
                String girlNameAmount = scan.next();
                if (gender == 'b' && boyName.equalsIgnoreCase(name)) {
                    found = true;
                } else if (gender == 'f' && girlName.equalsIgnoreCase(name)) {
                    found = true;
                }
            }
        }
        scan.close();
        return ranking;
    }

}
