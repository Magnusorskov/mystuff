package Lek04;

import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast 3 tal");
        String s;
        int one = scanner.nextInt();
        int two = scanner.nextInt();
        int three = scanner.nextInt();

        if (one < two && two < three) {
            s = "Stigende";
        } else if (one > two && two > three) {
            s = "Aftagende";
        } else {
            s = "Hverken eller";
        }
        System.out.println(s);
    }
}
