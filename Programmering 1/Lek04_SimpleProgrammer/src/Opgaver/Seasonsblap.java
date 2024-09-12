package Opgaver;
import java.util.Scanner;

public class Seasonsblap {
    public static String seasons(int month, int day) {
        String result;
        boolean divisbleBy3 = month % 3 == 0 && day >= 21;

        if (month < 4 && divisbleBy3) {
            result = "It's spring";
        } else if (month < 4) {
            result = "It's Winter";
        } else if (month < 7 && divisbleBy3) {
            result = "It's Summer";
        } else if (month < 7) {
            result = "It's Spring";
        } else if (month < 10 && divisbleBy3) {
            result = "It's Fall";
        } else if (month < 10) {
            result = "It's Summer";
        } else if (divisbleBy3) {
            result = "It's Winter";
        } else {
            result = "It's fall";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the day and month?");
        int day = scan.nextInt();
        int month = scan.nextInt();
        System.out.println("Currently " + seasons(month,day));
    }
}
