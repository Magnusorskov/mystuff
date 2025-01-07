package Opgaver;

import java.util.Scanner;

public class ReadIntPrintNegativNulEllerPositiv {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Write a number without decimals ");
        int answer = input.nextInt();

        String result;
        if (answer < 0) {
            result = "The number is negative";
        } else if (answer == 0) {
            result = "The number is zero";
        } else {
            result = "The number is positive";
        }
        System.out.print(result);
    }
}
