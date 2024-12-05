package soegningelevopgaver;

import java.util.ArrayList;
import java.util.Arrays;

public class SoegningApp {

    public static boolean findUlige(int[] tabel) {
        boolean uneven = false;
        int i = 0;
        while (!uneven && i < tabel.length) {
            if (tabel[i] % 2 != 0) {
                uneven = true;
            } else {
                i++;
            }
        }
        return uneven;
    }

    // her skriver du metoder til opgaverne 2,3,5,6 og 7

    // Opgave 2
    public static int tiTilFemten(int[] array) {
        int tal = -1;
        int i = 0;
        while (tal == -1 && i < array.length) {
            if (array[i] > 9 && array[i] < 16) {
                tal = array[i];
            } else {
                i++;
            }
        }
        return tal;
    }

    // Opgave 3
    public static boolean twoEquals(int[] array) {
        boolean twoEquals = false;
        int i = 1;
        int temp = array[0];
        while (!twoEquals && i < array.length) {
            if (temp == array[i]) {
                twoEquals = true;
            } else {
                temp = array[i];
                i++;
            }
        }
        return twoEquals;
    }

    // Opgave 6
    public static int find(ArrayList<Integer> list, int n) {
        int i = 0;
        int indeks = -1;
        while (indeks == -1 && i < list.size()) {
            if (list.get(i) == n) {
                indeks = i - 1;
                list.remove(list.get(i));
                list.add(i - 1, n);
            } else {
                i++;
            }
        }
        return indeks;
    }


    public static boolean kEns(String s, int k) {
        boolean kEns = false;
        int i = 0;
        while (!kEns && i <= s.length() - k) {
            if (match(s, i, k)) {
                kEns = true;
            } else {
                i++;
            }
        }
        return kEns;
    }

    public static boolean match(String s, int i, int k) {
        boolean same = true;
        int j = 1;
        while (same && j < k) {
            if (s.charAt(i + j) != s.charAt(i))
                same = false;
            else
                j++;
        }
        return same;
    }


    public static void main(String[] args) {
        // Kode til afprøvning af opgave 1
        int[] talArray = {2, 4, 8, 2};
        System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));
        talArray[2] = 15;
        System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));

        // Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7

        //opgave 2
        talArray = new int[]{7, 56, 34, 3, 7, 14, 13, 4};
        System.out.println(tiTilFemten(talArray));

        //opgave 3
        talArray = new int[]{7, 9, 13, 7, 9, 13};
        System.out.println(twoEquals(talArray));
        talArray = new int[]{7, 9, 13, 13, 9, 7};
        System.out.println(twoEquals(talArray));

        //Opgave 6
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(find(numbers, 30));
        System.out.println(numbers);

        //Opgave 7
        System.out.println(kEns("HEJSAASAA", 3));
    }

}
