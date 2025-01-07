package Lek04;

import java.util.Scanner;

public class ZellersCongruence {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek());
    }

    private static String dayOfTheWeek() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year: (e.g., 2012): ");
        int year = scanner.nextInt();
        System.out.println("Enter month: 1-12: ");
        int month = scanner.nextInt();
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        System.out.println("Enter day of the month: 1-31");
        int day = scanner.nextInt();

        int result = (day + (int) (26 * (month + 1) / 10.0) + year % 100 + (year % 100) / 4 + year / 400 - 2 * (year / 100)) % 7;

        String dayName = switch (result) {
            case 0 -> "saturday";
            case 1 -> "sunday";
            case 2 -> "monday";
            case 3 -> "tuesday";
            case 4 -> "wednesday";
            case 5 -> "thursday";
            case 6 -> "friday";
            default -> "";
        };

        return "Day of the week is " + dayName;
    }
}

