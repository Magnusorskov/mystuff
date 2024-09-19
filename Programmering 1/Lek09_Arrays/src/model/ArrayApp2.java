package model;

import java.util.Arrays;
import java.util.Locale;

public class ArrayApp2 {

    // Metode der adderer 1 til alle tal i array og returnerer en kopi
    public static int[] addOne(int[] tabel) {
        int[] result = new int[tabel.length];
        for (int i = 0; i < tabel.length; i++) {
            result[i] = tabel[i] + 1;
        }
        return result;
    }

    // Metode der adderer 1 til alle tal i input array
    public static void addOne2(int[] tabel) {
        for (int i = 0; i < tabel.length; i++) {
            tabel[i] = tabel[i] + 1;
        }
    }

    public static void shiftLeft(int[] tabel) {
        int temp = tabel[0];
        for (int i = 1; i < tabel.length; i++) {
            tabel[i - 1] = tabel[i];
        }
        tabel[tabel.length - 1] = temp;
    }


    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed(String[] tabel, char c) {
        int antal = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].charAt(0) == c) {
                antal++;
            }
        }
        return antal;
    }

    // Eksempel med forEach
    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed2(String[] tabel, char c) {
        int antal = 0;
        for (String tekst : tabel) {
            if (tekst.charAt(0) == c) {
                antal++;
            }
        }
        return antal;
    }


    // Opgave 1.1
    public static void swapFirstLast(int[] array) {
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    // Opgave 1.2
    public static void swapEvenWithZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }

    }

    // Opgave 1.3
    public static int smallestElement(int[] array) {
        int smallestNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallestNum) {
                smallestNum = array[i];
            }
        }
        return smallestNum;
    }

    // Opgave 1.4
    public static void pushRight(int[] array) {
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    // Opgave 1.5
    public static int secondSmallest(int[] array) {
        int smallestNumber = array[0];
        int secondSmallestNumber = 9999999;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallestNumber) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = array[i];
            } else if (array[i] < secondSmallestNumber) {
                secondSmallestNumber = array[i];
            }
        }
        return secondSmallestNumber;
    }

    // Opgave 1.5
    public static int secondLargest(int[] array) {
        int max = 0;
        int secondLargest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondLargest = max;
                max = array[i];
            } else if (array[i] > secondLargest) {
                secondLargest = array[i];

            }
        }
        return secondLargest;
    }

    // Opgave 1.6
    public static boolean sortedGrowing(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
            }
        }
        return sorted;
    }

    // Opgave 1.7
    public static boolean hasDoubleValue(int[] array) {
        boolean doubles = false;
        for (int i = 0; i < array.length; i++) {
            for (int c = i + 1; c < array.length; c++) {
                if (array[i] == array[c]) {
                    doubles = true;
                }
            }
        }
        return doubles;
    }

    // Opgave 2.1
    public static int amountOfStrings(String[] array) {
        int stringAmount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == 4) {
                stringAmount++;
            }
        }
        return stringAmount;
    }

    public static int amountOfStringsWithNLength(String[] array, int n) {
        int stringAmount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == n) {
                stringAmount++;
            }
        }
        return stringAmount;

    }

    public static String[] capitalizedLetters(String[] array) {
        String[] capitalizedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            capitalizedArray[i] = array[i].toUpperCase();
        }
        return capitalizedArray;
    }

    public static int forEachAmountOfStringsWith4(String[] array) {
        int amountOfStrings = 0;
        for (String word : array) {
            if (word.length() == 4) {
                amountOfStrings++;
            }
        }
        return amountOfStrings;
    }

    public static int forEachAmountOfStringsWithN(String[] array, int n) {
        int amountOfStrings = 0;
        for (String word : array) {
            if (word.length() == n) {
                amountOfStrings++;
            }
        }
        return amountOfStrings;
    }

    public static String[] forEachCapitalizedLettersArray(String[] array) {
        String [] capitalized = new String[array.length];
        int count = 0;
        for (String word : array) {
        capitalized[count] = array[count].toUpperCase();
        count++;
        }
        return capitalized;
    }

    public static void main(String[] args) {
        int[] tal = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(tal));
        int[] newTabel = addOne(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
        System.out.println("Nye  : " + Arrays.toString(newTabel));
        System.out.println();
        addOne2(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
//
        int[] copy = new int[tal.length];
        for (int i = 0; i < tal.length; i++) {
            copy[i] = tal[i];
        }


        System.out.println();
        shiftLeft(tal);
        System.out.println(Arrays.toString(tal));

        System.out.println();
        String[] navne = {"Maria", "Mette", "Lene", "Mona", "Jane"};
        System.out.println("Starter med M: " + starterMed(navne, 'M'));
        //System.out.println("Starter med M: " + starterMed2(navne,'M'));

        //Opgave 1.1
        int[] opgave1_1 = {3, 2, 3, 4, 5};
        swapFirstLast(opgave1_1);
        System.out.println(Arrays.toString(opgave1_1));

        //Opgave 1.2
        int[] opgave1_2 = {1, 2, 3, 4, 5, 6};
        swapEvenWithZero(opgave1_2);
        System.out.println(Arrays.toString(opgave1_2));

        //Opgave 1.3
        int[] Opgave1_3 = {1, 5, 2, 5};
        System.out.println(smallestElement(Opgave1_3));

        //Opgave 1.4
        int[] Opgave1_4 = {1, 2, 3, 4};
        System.out.println("1_4 before moving numbers " + Arrays.toString(Opgave1_4));
        pushRight(Opgave1_4);
        System.out.println("1_4 after moving numbers " + Arrays.toString(Opgave1_4));

        // Opgave 1.5
        int[] Opgave1_5 = {0, 13, 7, 6};
        System.out.println(secondLargest(Opgave1_5));

        // Opgave 1.6
        int[] Opgave1_6 = {1, 2, 3, 4, 5};
        System.out.println("{1,2,3,4,5} is growing = " + sortedGrowing(Opgave1_6));
        int[] Opgave1_6_1 = {2, 1, 3, 4, 5};
        System.out.println("{2,1,3,4,5} is growing = " + sortedGrowing(Opgave1_6_1));

        // Opgave 1.7
        int[] Opgave1_7 = {1, 2, 3, 4, 5};
        System.out.println("{1,2,3,4,5} has doubles = " + hasDoubleValue(Opgave1_7));
        int[] Opgave1_7_1 = {1, 1, 2, 3, 4, 5};
        System.out.println("{1,1,2,3,4,5} has doubles = " + hasDoubleValue(Opgave1_7_1));

        // Opgave 2.1
        String[] Opgave2_1 = {"hejj", "med", "digg"};
        System.out.println("{\"hejj\", \"med\", \"digg\"} has " + amountOfStrings(Opgave2_1) + " " +
                "strings with the value 4");

        // Opgave 2.2
        String[] Opgave2_2 = {"hejj", "med", "digg", "hopp", "dsa"};
        System.out.println("{\"hejj\", \"med\", \"digg\", \"hopp\", \"dsa\"} has " + amountOfStringsWithNLength(Opgave2_2, 3) +
                " strings with the value 3");
        System.out.println("{\"hejj\", \"med\", \"digg\", \"hopp\", \"dsa\"} has " + amountOfStringsWithNLength(Opgave2_2, 4) +
                " strings with the value 4");

        // Opgave 2.3
        String[] Opgave2_3 = {"dette", "er", "en", "test"};
        System.out.println(Arrays.toString(Opgave2_3));
        System.out.println(Arrays.toString(capitalizedLetters(Opgave2_3)));
        System.out.println(Arrays.toString(Opgave2_3));

        // Opgave 3.1
        String[] Opgave3_1 = {"hejj", "med", "digg"};
        System.out.println("{\"hejj\", \"med\", \"digg\"} has " + forEachAmountOfStringsWith4(Opgave3_1) + " words with the length of 4");

        // Opgave 3.2
        String[] Opgave3_2 = {"hejj", "med", "digg", "hopp", "dsa"};
        System.out.println("{\"hejj\", \"med\", \"digg\", \"hopp\", \"dsa\"} has " + amountOfStringsWithNLength(Opgave3_2, 3) +
                " strings with the value 3");
        System.out.println("{\"hejj\", \"med\", \"digg\", \"hopp\", \"dsa\"} has " + amountOfStringsWithNLength(Opgave3_2, 4) +
                " strings with the value 4");

        // Opgave 3.3
        String[] Opgave3_3 = {"dette", "er", "en", "test"};
        System.out.println(Arrays.toString(Opgave3_3));
        System.out.println(Arrays.toString(forEachCapitalizedLettersArray(Opgave3_3)));
        System.out.println(Arrays.toString(Opgave3_3));
    }
}

