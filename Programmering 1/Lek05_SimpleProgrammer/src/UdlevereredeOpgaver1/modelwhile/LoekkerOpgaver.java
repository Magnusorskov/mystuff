package UdlevereredeOpgaver1.modelwhile;

import java.sql.SQLOutput;

public class LoekkerOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

        System.out.println(summerEven(100));
        System.out.println(summerSquare(10));
        System.out.println(sumOdd(2, 20));
        allPowers(20);
        System.out.println(sumDigits(32677));

    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int i = 2;
        int sum = 0;

        while (i <= n) {
            sum = sum + i;
            i++;
            i++;
        }
        return sum;
    }


    //    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum = sum + i * i;
            i++;
        }
        return sum;
    }

    //
    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int sum = 0;
        int i = a;

        while (i <= b) {
            if (i % 2 != 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser
    public static void allPowers(int n) {
        int sum = 1;
        int i = 0;

        while (i <= n) {
            System.out.println("2^" + i + " = " + sum);
            sum = (sum * 2);
            i++;
        }

    }

    public static int sumDigits(int a) {
        int sum = 0;

        while (a > 0) {
            if (a % 2 != 0) {
                sum = sum + (a % 10);
            }
                a = a / 10;
            }
        return sum;
    }
}







