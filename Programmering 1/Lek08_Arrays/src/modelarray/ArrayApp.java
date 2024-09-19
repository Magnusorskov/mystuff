package modelarray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayApp {
    public static int[] fyldArrayPP() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i * 3;
        }
        return result;
    }

    public static int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public static void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            } else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    // OPGAVER


    /**
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public static int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public static int[] fyldArrayB() {
        //int[] result =new int[10];
        int[] result = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public static int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public static int[] fyldArrayD() {
        int[] result = new int[10];
        int tal = 2;
        for (int i = 0; i < result.length; i++) {
            result[i] = tal;
            tal = tal += 2;
        }
        return result;
    }

    /**
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public static int[] fyldArrayE() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }

    /**
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public static int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 1; i < result.length; i++) {
            result[i] = i % 2;
        }
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public static int[] fyldArrayG() {
        int[] result = new int[10];
        for (int i = 1; i < result.length; i++)
            result[i] = i % 5;


        return result;
    }

    public static int findSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static double findSumDouble(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static int antalLige(int[] array) {
        int ligeCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ligeCount++;
            }
        }
        return ligeCount;
    }

    public static int antalForekomster(int[] array, int tal) {
        int talForekomst = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tal) {
                talForekomst++;
            }
        }
        return talForekomst;
    }

    public static int[] makeSum(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public static boolean hasUneven(int[] array) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int tabel[] = fyldArrayPP();
        System.out.println("Forventet: [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));

        int[] tabel2 = {78, 23, 1, 4, 65, 3, 87, 5, 12};
        printArray(tabel2);
        System.out.println(findMax(tabel2));

        tabel = fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        int[] test = {10, 12, 14, 13, 14};
        int[] test2 = {10, 12, 13, 14, 15};
        double[] testDouble = {10.222, 10.222};
        System.out.println(findSum(test));
        System.out.println(findSumDouble(testDouble));
        System.out.println(antalLige(test));
        System.out.println(antalForekomster(test, 13));

        int[] nytArray = makeSum(test, test2);
        System.out.println(Arrays.toString(nytArray));

        System.out.println(hasUneven(test));
    }

}
