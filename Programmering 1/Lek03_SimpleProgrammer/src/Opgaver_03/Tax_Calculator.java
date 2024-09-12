package Opgaver_03;
import java.util.Scanner;

public class Tax_Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your salary? ");
        double salary = input.nextDouble();
        double yearlyTax = (salary * 12 - 48000) * 37 / 100;
        double monthlyTax = yearlyTax / 12;

        System.out.print("Your yearly tax is " + yearlyTax + " and your monthly tax is " + monthlyTax);
    }
}
