package model;

import java.util.Scanner;
//  (Find the index of the largest element)
public class Opgave7_10 {
    public static void main(String[] args) {
        double[] tenNumbersArray = new double[10];

        System.out.println("Enter 10 numbers");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int userNumber = input.nextInt();
            tenNumbersArray[i] = userNumber;
        }
        int largestIndex = indexOfLargestElement(tenNumbersArray);
        System.out.println("The largest number/element was " + tenNumbersArray[largestIndex] +
                " and that number/element has the index number of " + largestIndex);
    }

    public static int indexOfLargestElement(double[] array) {
        double largestElement = 0;
        int indexNumber = 0;

        for (int i = 0; i < array.length; i++) {
        if (i > indexNumber && array[i] == largestElement){
            indexNumber = i;
            }
        else if (array[i] > largestElement){
            largestElement = array[i];
            indexNumber = i;
        }
        }
        return indexNumber;
    }
}
