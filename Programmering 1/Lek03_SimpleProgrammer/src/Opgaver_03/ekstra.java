package Opgaver_03;
import java.util.Scanner;

public class ekstra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 0 and 9999 ");
        int number = input.nextInt();

        int rest1 = number % 10;
        number = number / 10;
        int rest2 = number % 10;
        number = number / 10;
        int rest3 = number % 10;
        number = number / 10;
        int rest4 = number % 10;

        int sum = (rest1 + rest2 + rest3 + rest4);

        System.out.println("The sum of the digits is " + sum);
    }
}
