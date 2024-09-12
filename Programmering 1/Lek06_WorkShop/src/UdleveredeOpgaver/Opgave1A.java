package UdleveredeOpgaver;
import java.util.Scanner;

//  I denne opgave skal der i alle spørgsmål indlæses et antal hele tal mellem 1 og
//  99, afsluttende med 0. Det afsluttende 0 må ikke behandles i løkken.
//  (For dem som kender til break sætningen: break må ikke anvendes.)
//  Som inspiration se klassen FindMax som I fik udleveret ved lektion5.
//
//  a) Lav et program, der indlæser tallene og udskriver det største tal, det
//  mindste tal, antal lige tal og antal ulige tal.
//
//  b) Lav et program, der indlæser tallene og udskriver den løbende sum.
//  Indtastes 1 7 2 9 0, skal programmet udskrive 1 8 10 19.

public class Opgave1A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int max = 0;
        int min = 100;
        int even = 0;
        int uneven = 0;

        System.out.println("\nInput a number. End with 0");
        int number = scan.nextInt();

        while (number != 0) {
            if (number > max) {
                max = number;
            }
            if (number < 100 && number < min) {
                min = number;
            }
            if (number % 2 == 0) {
                even++;
            } else uneven++;
            System.out.println("\nInput a number. End with 0");
            number = scan.nextInt();
        }
        System.out.println("Max number is " + max);
        System.out.println("Min number is " + min);
        System.out.println("Amount of even numbers is " + even);
        System.out.println("Amount of uneven numbers is " + uneven);
    }

    }
