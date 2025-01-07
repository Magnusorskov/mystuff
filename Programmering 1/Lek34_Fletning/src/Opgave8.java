import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave8 {
    public static void main(String[] args) {
        try {
            findfællesTal("heltal1.txt", "heltal2.txt", "heltal3.txt");
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    public static void findfællesTal(String fileName1, String
            fileName2, String fileNameNy) throws FileNotFoundException {
        File fileIn1 = new File(fileName1);
        File fileIn2 = new File(fileName2);
        PrintWriter newFile = new PrintWriter(fileNameNy);
        Scanner scan1 = new Scanner(fileIn1);
        Scanner scan2 = new Scanner(fileIn2);
        int number1 = scan1.nextInt();
        int number2 = scan2.nextInt();

        while (scan1.hasNext() && scan2.hasNext()) {
            if (number1 < number2) {
                number1 = scan1.nextInt();
            } else if (number1 > number2) {
                number2 = scan2.nextInt();
            } else {
                newFile.println(number1);
                number1 = scan1.nextInt();
                number2 = scan2.nextInt();
            }
        }

        boolean found = false;
        while (scan1.hasNext() && !found) {
            if (number1 > number2) {
                found = true;
            } else if (number1 < number2) {
                number1 = scan1.nextInt();
            } else {
                newFile.println(number1);
                found = true;
            }
        }

        while (scan2.hasNext() && !found) {
            if (number1 < number2) {
                found = true;
            } else if (number1 > number2) {
                number2 = scan2.nextInt();
            } else {
                newFile.println(number1);
                found = true;
            }
        }

        if (number1 == number2 && !found) {
            newFile.println(number1);
        }
        scan1.close();
        scan2.close();
        newFile.close();
    }

    public static void fletAlleHeltal(String fileName1, String
            fileName2, String fileNameNy) throws FileNotFoundException {
        File fileIn1 = new File(fileName1);
        File fileIn2 = new File(fileName2);
        PrintWriter newFile = new PrintWriter(fileNameNy);
        Scanner scan1 = new Scanner(fileIn1);
        Scanner scan2 = new Scanner(fileIn2);

        int number1 = scan1.nextInt();
        int number2 = scan2.nextInt();

        while (scan1.hasNext() && scan2.hasNext()) {
            if (number1 <= number2) {
                newFile.println(number1);
                number1 = scan1.nextInt();
            } else {
                newFile.println(number2);
                number2 = scan2.nextInt();
            }
        }

        while (scan1.hasNext()) {
            newFile.println(number1);
            number1 = scan1.nextInt();
        }

        while (scan2.hasNext()) {
            newFile.println(number2);
            number2 = scan2.nextInt();
        }

        if (number1 <= number2) {
            newFile.println(number1);
            newFile.println(number2);
        } else {
            newFile.println(number2);
            newFile.println(number1);
        }

        scan1.close();
        scan2.close();
        newFile.close();
    }
}
