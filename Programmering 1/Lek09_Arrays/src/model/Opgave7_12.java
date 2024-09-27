package model;

import java.util.Arrays;
import java.util.Scanner;

//(Reverse an array)
public class Opgave7_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers do you want me to reverse?");
        int numberCount = input.nextInt();
        int[] Arrayx = new int[numberCount];

        System.out.println("Enter " + numberCount + " numbers");
        for (int i = 0; i < Arrayx.length; i++) {
            System.out.println(i + " out of " + numberCount);
            Arrayx[i] = input.nextInt();
        }
        System.out.println("The array before reversal is = " + Arrays.toString(Arrayx));
        reverseArray(Arrayx);
        System.out.println("The array after reversal is = " + Arrays.toString(Arrayx));
    }

    public static int[] reverseArray(int[] array) {

        int reverseCount = 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - reverseCount];
            array[array.length - reverseCount] = temp;
            reverseCount++;
        }
        return array;
    }
}
