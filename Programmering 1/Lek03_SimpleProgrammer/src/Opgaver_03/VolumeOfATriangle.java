package Opgaver_03;
import java.util.Scanner;

public class VolumeOfATriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter length of a side of an equilateral triangle ");
        double triangleSide = input.nextDouble();
        double area = (Math.sqrt(3) / 4 * (triangleSide * triangleSide));
        double volume = area * triangleSide;

        System.out.print("The area of the triangle is " + area + " and the volume of the triangle is " + volume);

    }
}
