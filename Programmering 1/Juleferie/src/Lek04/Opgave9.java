package Lek04;

import java.util.Scanner;

public class Opgave9 {
    public static void main(String[] args) {
        System.out.println(futureDate());
    }

    private static String futureDate() {
        Scanner scan = new Scanner(System.in);
        String today = "";
        System.out.println("Write todays number(Sunday 0, Monday 1...");
        int todayNumber = scan.nextInt();

        switch (todayNumber) {
            case 0:
                today = "Sunday";
                break;
            case 1:
                today = "Monday";
                break;
            case 2:
                today = "Tuesday";
                break;
            case 3:
                today = "Wednesday";
                break;
            case 4:
                today = "Thursday";
                break;
            case 5:
                today = "Friday";
                break;
            case 6:
                today = "Saturday";
        }

        System.out.println("Enter the number of days elapsed since today: ");
        int daysElapsed = scan.nextInt();
        int futureDay = (todayNumber + daysElapsed) % 7;
        String futureDays = "";
        switch (futureDay) {
            case 0:
                futureDays = "Sunday";
                break;
            case 1:
                futureDays = "Monday";
                break;
            case 2:
                futureDays = "Tuesday";
                break;
            case 3:
                futureDays = "Wednesday";
                break;
            case 4:
                futureDays = "Thursday";
                break;
            case 5:
                futureDays = "Friday";
                break;
            case 6:
                futureDays = "Saturday";
        }
        today = "Today is " + today + " and the future day is " + futureDays;
        return today;
    }
}
