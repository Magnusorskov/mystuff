package Opgaver;
import java.util.Scanner;

public class AscendingDescendingNeither {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Write 3 numbers ");

        int tal1 = input.nextInt();
        int tal2 = input.nextInt();
        int tal3 = input.nextInt();

        String result;

        if (tal1 < tal2 && tal2 < tal3) {
            result = "The numbers are ascending";
        }
        else if (tal1 > tal2 && tal2 > tal3) {
            result = "The numbers are descending";
        }
        else {
            result = "The three numbers are neither descending or ascending";
        }
        System.out.println(result);

    }
}
