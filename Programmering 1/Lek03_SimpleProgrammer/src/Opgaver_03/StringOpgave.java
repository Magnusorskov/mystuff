package Opgaver_03;

import java.util.Locale;

public class StringOpgave {
    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        //lave ord1 om til uppercase
        String ord1Stor = ord1.toUpperCase();

        //lave ord2 til lowercase
        String ord2Lille = ord2.toLowerCase();

        //ny string der kombinerer ord1 og ord2 i lower case
        String ord3 = ord1 + ord2.toLowerCase();

        //udskriv de første 7 bogstaver af ord1
        String lengthOrd1 = ord1.substring(0, 7);

        //lav variabel len der viser mængden af karakterer i ord3
        int len = ord3.length();

        //print string ord1Stor
        System.out.println(ord1Stor);

        //print string ord2Lille
        System.out.println(ord2Lille);

        //print ord1 og ord2 med et mellemrum imellem
        System.out.println(ord1 + " " + ord2);

        System.out.println(ord3);
        System.out.println(len);
        System.out.println(lengthOrd1);
        System.out.println(ord2.substring(2, 7));
        System.out.println(ord3.substring(11));



    }
}
