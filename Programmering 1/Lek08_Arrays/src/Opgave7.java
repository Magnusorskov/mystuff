import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[50];

        System.out.println("Enter numbers between 1 and 50. End with 0");
        int i = input.nextInt();
        while (i != 0) {
            numbers[i - 1]++;
            i = input.nextInt();
        }
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] != 0) {
                if (numbers[j] > 1)
                    System.out.println((j + 1) + " occurs " + numbers[j] + " times");
                else {
                    System.out.println((j + 1) + " occurs " + numbers[j] + " time");
                }
            }
        }
    }
}