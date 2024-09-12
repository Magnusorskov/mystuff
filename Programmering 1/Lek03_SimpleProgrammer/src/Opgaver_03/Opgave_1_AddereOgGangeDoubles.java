package Opgaver_03;
import java.util.Scanner;

public class Opgave_1_AddereOgGangeDoubles {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Indtast første tal ");
        double førsteTal = input.nextDouble();

        System.out.print("Indtast andet tal ");
        double andetTal = input.nextDouble();

        System.out.print("Indtast tredje tal ");
        double tredjeTal = input.nextDouble();

        System.out.print("Summen af de tre tal er = ");
        System.out.println(førsteTal + andetTal + tredjeTal);

        System.out.print("Produktet af de tre tal er = ");
        System.out.println(førsteTal * andetTal * tredjeTal);
    }

}
