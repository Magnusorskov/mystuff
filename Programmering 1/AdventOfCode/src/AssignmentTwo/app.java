package AssignmentTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        try {
            System.out.println(safeReports());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int safeReports() throws FileNotFoundException {
        File fileIn = new File("adventOfCode2.txt");
        Scanner scan = new Scanner(fileIn);
        int count = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner scanLine = new Scanner(line);

            boolean ascendOrDescend = true;
            boolean ascending = false;
            boolean descending = false;
            int firstNumber = Integer.parseInt(scanLine.next());
            int prevNumber = firstNumber; // Store the previous number

            while (scanLine.hasNext() && ascendOrDescend) {
                int nextNumber = Integer.parseInt(scanLine.next());
                int diff = nextNumber - prevNumber; // Calculate the difference

                // Check difference rule
                if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                    ascendOrDescend = false;
                    break; // Exit the inner loop if the difference is invalid
                }

                // Check ascending/descending rule (simplified)
                if (nextNumber > prevNumber && !descending) {
                    ascending = true;
                } else if (nextNumber < prevNumber && !ascending) {
                    descending = true;
                } else if (nextNumber == prevNumber) { // Handle equal numbers
                    ascendOrDescend = false;
                    break;
                } else { // If neither ascending nor descending is consistent
                    ascendOrDescend = false;
                    break;
                }

                prevNumber = nextNumber;
            }

            if (ascendOrDescend) {
                count++;
            }
            scanLine.close();
        }
        scan.close();
        return count;
    }
}




