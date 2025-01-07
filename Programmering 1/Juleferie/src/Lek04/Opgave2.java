package Lek04;

import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast tal");
        int tal = scanner.nextInt();
        String s;

        if (tal < 0) {
           s = "Tallet er negativt";
        } else if (tal == 0) {
            s = "Tallet er 0";
        } else {
            s = "Tallet er positivt";
        }
        System.out.println(s);
    }
}
