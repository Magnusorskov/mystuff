package model;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsArrayList {

    /**
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public static int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            //	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * @param list
     * @return sums the mumbers in the list using a forEach loop
     */
    public static int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * @param list
     * @return index at the first even number
     */
    public static int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;

    }

    public static int minInt(ArrayList<Integer> list) {
        int minInt = Integer.MAX_VALUE;
        for (int number : list) {
            if (number < minInt) {
                minInt = number;
            }
        }
        return minInt;
    }

    public static double average(ArrayList<Integer> list) {
        double sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum / list.size();
    }

    public static int countZeros(ArrayList<Integer> list) {
        int zeroCount = 0;
        for (int number : list) {
            if (number == 0) {
                zeroCount++;
            }
        }
        return zeroCount;
    }

    public static void swapEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }

    }

    public static ArrayList<Integer> anEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (Integer number : list) {
            if (number % 2 == 0) {
                evenList.add(number);
            }
        }
        return evenList;
    }

    public static void swapFirstLast(ArrayList<Integer> list) {
        int temp = list.getLast();
        list.set(list.size() - 1, list.getFirst());
        list.set(0, temp);
    }


    public static void pushOneRight(ArrayList<Integer> list) {
        list.addFirst(list.getLast());
        list.removeLast();
    }

    public static int secondLargestNum(ArrayList<Integer> list) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : list) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            }
        }
        return secondLargest;
    }

    public static boolean isListGrowing(ArrayList<Integer> list) {
        boolean growing = true;
        int i = 0;
        while (growing && i < list.size() - 1) {
            if (list.get(i) > list.get(i + 1)) {
                growing = false;
            }
            i++;
        }
        return growing;
    }

    public static boolean hasDoubles(ArrayList<Integer> list) {
        boolean doubles = false;
        for (int i = 0; i < list.size() && !doubles; i++) {
            for (int j = i + 1; j < list.size() && !doubles; j++) {
                if (list.get(i) == list.get(j)) {
                    doubles = true;
                }
            }
        }
        return doubles;
    }

    public static boolean hasDoublesMargretheVersion(ArrayList<Integer> list) {
        boolean doubles = false;
        int i = 0;
        int j = i+1;

        while (i < list.size() && !doubles) {
            while (j < list.size() && !doubles) {
                if (list.get(i) == list.get(j)) {
                    doubles = true;
                }
                j++;
            }
            i++;
        }
        return doubles;
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> characterArray = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            characterArray.add(s.charAt(i));
        }
        return characterArray;
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(14);
        list.add(30);
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for "
                + sumListe(list));
        System.out.println("Summen af tallene i listen med forEach "
                + sumListe2(list));

        System.out.println("Indeks for det første lige tal: "
                + hasEvenAtIndex(list));

        System.out.println(minInt(list));

        System.out.println(average(list));

        System.out.println(countZeros(list));

//        swapEvenWithZero(list);
//        System.out.println(list);

        System.out.println(anEvenList(list));
        swapFirstLast(list);
        System.out.println(list);
        pushOneRight(list);
        System.out.println(list);
        System.out.println(secondLargestNum(list));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(34);
        list2.add(36);
        System.out.println(isListGrowing(list2));
        System.out.println(hasDoubles(list2));
        System.out.println(toCharacterArray("dkskdsfsdf"));

        ArrayList<Integer> duplicateList = new ArrayList<>();
        System.out.println("Enter 10 numbers: ");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
        duplicateList.add(scan.nextInt());
        System.out.println(i+1 + " out of 10");
        }
        removeDuplicate(duplicateList);
        System.out.println(duplicateList);
    }



}
