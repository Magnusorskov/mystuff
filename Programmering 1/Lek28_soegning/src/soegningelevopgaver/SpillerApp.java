package soegningelevopgaver;

import java.util.ArrayList;

public class SpillerApp {
    // OPGAVE 4.1
    public static Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int i = 0;
        while (spiller == null && i < spillere.size()) {
            if (spillere.get(i).getMaal() == score) {
                spiller = spillere.get(i);
            } else {
                i++;
            }
        }
        return spiller;
    }

    // OPGAVE 4.2
    public static Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int high = 0;
        int low = spillere.size() - 1;

        while (spiller == null && high <= low) {
            int middle = (high + low) / 2;
            Spiller k = spillere.get(middle);

            if (k.getMaal() == score) {
                spiller = k;
            } else if (k.getMaal() < score) {
                low = middle - 1;
            } else {
                high = middle + 1;
            }
        }
        return spiller;
    }


    // OPGAVE 4.3
    public static String godSpiller(ArrayList<Spiller> spillere) {
        String name = null;
        int i = 0;
        while (name == null && i < spillere.size()) {
            if (spillere.get(i).getHoejde() < 170 && spillere.get(i).getMaal() >= 50) {
                name = spillere.get(i).getNavn();
            } else {
                i++;
            }
        }
        return name;
    }

    // OPGAVE 5
    public static int heltalsKvadratRodLineær(int number) {
        int tal = -1;
        int i = 0;
        while (i <= number && tal == -1) {
            if (i * i <= number && (i + 1) * (i + 1) > number) {
                tal = i;
            } else {
                i++;
            }
        }
        return tal;
    }

    public static int heltalsKvadratRodBinær(int number) {
        int tal = -1;
        int high = number;
        int low = 0;

        while (tal == -1 && high >= low) {
            int middle = (high + low) / 2;
            if (middle * middle <= number && (middle + 1) * (middle + 1) > number) {
                tal = middle;
            } else if (middle * middle < number) {
                low = middle - 1;
            } else {
                high = middle + 1;
            }
        }
        return tal;
    }

    public static void main(String[] args) {

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Jens", 160, 109, 64));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));


        System.out.println("Spiller der har scoret 35 mål: " + findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3

        System.out.println(spillerListe);
        // 4.3
        System.out.println(godSpiller(spillerListe));

        System.out.println(findScoreBinær(spillerListe, 12));

        System.out.println(heltalsKvadratRodLineær(0));
        System.out.println(heltalsKvadratRodLineær(1));
        System.out.println(heltalsKvadratRodLineær(3));
        System.out.println(heltalsKvadratRodLineær(4));
        System.out.println(heltalsKvadratRodLineær(7));
        System.out.println(heltalsKvadratRodLineær(111));
        System.out.println(heltalsKvadratRodBinær(7));
    }

}
