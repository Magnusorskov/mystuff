package udleveret_if;

import java.util.Scanner;

public class ChildApp {

    // Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String institution(int age) {

        String result;

        if (age == 0) {
            result = " should stay home";
        } else if (age < 2) {
            result = " should be in nursery";
        } else if (age < 6) {
            result = " should be in kindergarten";
        } else if (age < 17) {
            result = " should be in school";
        } else
            result = " is out of school";
        return result;

    }


    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String team(boolean isBoy, int age) {

        String result;

        if (isBoy && age < 8) {
            result = "Young Cubs";
        } else if (isBoy) {
            result = "Cool Boys";
        } else if (age < 8) {
            result = "Tumbling Girls";
        } else {
            result = "Springy girls";
        }

        return result;
    }

    public static String sign(int tal) {
        String result;
        if (tal < 0) {
            result = " is negative";
        } else if (tal == 0) {
            result = "0 is zero";
        } else {
            result = " is positive";
        }
        return result;
    }

    public static String inorder(int num1, int num2, int num3) {
        String result;
        if (num1 < num2 && num2 < num3) {
            result = " are ascending";
        } else if (num1 > num2 && num2 > num3) {
            result = " are descending";
        } else {
            result = " are neither descending or ascending";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("A child that is 5 years old" + institution(5));
        System.out.println("A child that is 0 years old" + institution(0));
        System.out.println("A child that is 1 years old" + institution(1));
        System.out.println("A child that is 6 years old" + institution(6));
        System.out.println("A child that is 18 years old" + institution(18));
        System.out.println("En dreng på 8 skal i " + team(true, 8));
        System.out.println("En dreng på 3 skal i " + team(true, 3));
        System.out.println("En pige på 8 skal i " + team(false, 8));
        System.out.println("En pige på 3 skal i " + team(false, 3));
        System.out.println("The number 1" + sign(1));
        System.out.println("The number " + sign(0));
        System.out.println("The number -1" + sign(-1));
        System.out.println("The numbers 1, 2, 3" + inorder(1, 2, 3));
        System.out.println("The numbers 3, 2, 1" + inorder(3, 2, 1));
        System.out.println("The numbers 4, 2, 6" + inorder(4, 2, 6));

    }
}
