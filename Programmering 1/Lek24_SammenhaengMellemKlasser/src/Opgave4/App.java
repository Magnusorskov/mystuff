package Opgave4;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Hund> hunde = new ArrayList<>();
        Hund hund1 = new Hund("Børge", true, 3000, Race.BOKSER);
        hunde.add(hund1);
        Hund hund2 = new Hund("Ko", true, 4000, Race.BOKSER);
        hunde.add(hund2);
        Hund hund3 = new Hund("Gris", true, 2000, Race.PUDDEL);
        hunde.add(hund3);
        Hund hund4 = new Hund("Høne", true, 10000, Race.TERRIER);
        hunde.add(hund4);
        Hund hund5 = new Hund("Bo", true, 1000, Race.TERRIER);
        hunde.add(hund5);

        System.out.println(samletPris(hunde,Race.TERRIER));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int samletPris = 0;
        for (Hund hund: hunde) {
            if (hund.getRace() == race) {
                samletPris += hund.getPris();
            }
        }
        return samletPris;
    }
}
