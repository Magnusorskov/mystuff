package Opgaver;
import java.util.Scanner;

public class Opg3_5_FindFutureDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number from 0-6 that corresponds to today's day of the week (sun=0, mon=1, ..., sat=6): ");
        int dayOfTheWeek = scan.nextInt();
        if (dayOfTheWeek < 0 || dayOfTheWeek > 6) {
            System.out.print("Invalid input");
            return; // exit program
        }

        System.out.println("How many days should pass before we reach the future day? ");
        int daysPassed = scan.nextInt();

        int futureDay = (dayOfTheWeek + daysPassed) % 7;

        // Debug prints
        System.out.println("Debug: dayOfTheWeek = " + dayOfTheWeek);
        System.out.println("Debug: daysPassed = " + daysPassed);
        System.out.println("Debug: futureDay = " + futureDay);

        System.out.print("Today is");
        switch (dayOfTheWeek) {
            case 0:
                System.out.print(" Sunday");
                break;
            case 1:
                System.out.print(" Monday");
                break;
            case 2:
                System.out.print(" Tuesday");
                break;
            case 3:
                System.out.print(" Wednesday");
                break;
            case 4:
                System.out.print(" Thursday");
                break;
            case 5:
                System.out.print(" Friday");
                break;
            case 6:
                System.out.print(" Saturday");
                break;
        }

        System.out.print(" and the future day is");
        switch (futureDay) {
            case 0:
                System.out.print(" Sunday");
                break;
            case 1:
                System.out.print(" Monday");
                break;
            case 2:
                System.out.print(" Tuesday");
                break;
            case 3:
                System.out.print(" Wednesday");
                break;
            case 4:
                System.out.print(" Thursday");
                break;
            case 5:
                System.out.print(" Friday");
                break;
            case 6:
                System.out.print(" Saturday");
                break;
        }
    }
}