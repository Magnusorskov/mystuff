package Opgaver_03;
import java.util.Scanner;

public class Opgave_2_beregnMoms {
    public static void main(String[] args) {
        // programmet skal tage et beløb som imput og så skal den beregne hvad momsen er (25% af input) og så udskrive moms

        Scanner input = new Scanner(System.in);
        double tax = 1.25;

        System.out.println("Input your start value ");
        double startBeløb = input.nextDouble();

        System.out.print("Your value with added tax is ");
        System.out.println(startBeløb * tax);

    }
}
