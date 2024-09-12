package test;

import java.util.Scanner;
public class seasons2 {

    public static String seasons(int month, int day) {
        if (month < 4) {
            return day >= 21 ? "Spring" : "Winter";
        } else if (month < 7) {
            return day >= 21 ? "Summer" : "Spring";
        } else if (month < 10) {
            return day >= 21 ? "Fall" : "Summer";
        } else {
            return day >= 21 ? "Winter" : "Fall";
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("What is the day and month?");
        int day = scan.nextInt();
        int month = scan.nextInt();
        System.out.println("Currently " + seasons(month, day));
    }
}

