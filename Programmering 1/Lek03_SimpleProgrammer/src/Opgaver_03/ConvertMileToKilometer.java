package Opgaver_03;
import java.util.Scanner;

public class ConvertMileToKilometer {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many miles you wish to convert to kilometers ");

        double miles = input.nextDouble();
        double kilometers = (miles * 1.6);

        System.out.print(miles + " miles is equal to " + kilometers + " kilometers");
    }
}
