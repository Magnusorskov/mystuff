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
public class Opgave1B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number you would like to add, 0 to end");
        int num = scan.nextInt();
        int sum = 0;
        int i = 1;

        while (num != 0) {
            sum = sum + num;
            System.out.print(sum);
            System.out.print(" ");
            System.out.println("Enter a number you would like to add, 0 to end");
            num = scan.nextInt();
        }
        }
        }


