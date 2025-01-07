package Lek04;

import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {

    }

    private static String inOrder(int one, int two, int three) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast 3 tal");
        String s;
        one = scanner.nextInt();
        two = scanner.nextInt();
        three = scanner.nextInt();

        if (one < two && two < three) {
            s = "Stigende";
        } else if (one > two && two > three) {
            s = "Aftagende";
        } else {
            s = "Hverken eller";
        }
        return s;
    }
}
