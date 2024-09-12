package Opgaver_03;
import java.util.Scanner;

public class SubtotalAndGratuity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the subtotal? ");
        double subtotal = input.nextDouble();

        System.out.println("What is the gratuity rate? ");
        double gratuityRate = input.nextDouble();

        double gratuity = subtotal / 100 * gratuityRate;
        double total = gratuity + subtotal;

        System.out.println("The gratuity is " + gratuity + " and the total is " + total);

    }
}
