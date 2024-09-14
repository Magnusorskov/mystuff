package UdlevereredeOpgaver1.modelwhile;

public class ReverseOrder {
    public static void main(String[] args) {
        reverse(3456);
    }

    public static void reverse(int number) {

        while (number >= 1) {
            System.out.print(number % 10);
            number = number / 10;


        }
    }

}

