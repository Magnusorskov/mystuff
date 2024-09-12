package UdlevereredeOpgaver1.modelwhile;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

        System.out.println("We're playing FizzBuzz! What number are we playing to?");
        int gameNumber = scan.nextInt();
        int i = 1;

        while (i <= gameNumber) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FIZZBUZZ!");
            } else if (i % 3 == 0) {
                System.out.println("FIZZ!");
            } else if (i % 5 == 0) {
                System.out.println("BUZZ!");
            } else {
                System.out.println("The number is " + i + ".");
            }
            i++;
        }


    }
}
