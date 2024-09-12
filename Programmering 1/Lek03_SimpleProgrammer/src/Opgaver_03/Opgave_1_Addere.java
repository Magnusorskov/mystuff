package Opgaver_03;
import java.util.Scanner;

public class Opgave_1_Addere {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in) ;

        System.out.print("Indtast første tal ");
        int førsteTal = input.nextInt() ;

        System.out.print("Indtast andet tal ");
        int andetTal = input.nextInt() ;

        System.out.print("Indtast tredje tal ");
        int tredjeTal = input.nextInt() ;

        System.out.print("Summen af de tre tal = ");
        System.out.print(førsteTal + andetTal + tredjeTal);
    }
}
