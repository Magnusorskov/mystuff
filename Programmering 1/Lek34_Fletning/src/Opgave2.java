import java.util.Arrays;

public class Opgave2 {
    public static void main(String[] args) {
        int[] tal1 = new int[]{2, 4, 6, 8, 10, 12, 14};
        int[] tal2 = new int[]{1, 2, 4, 5, 6, 9, 12, 17};
        System.out.println(Arrays.toString(fællesTal(tal1, tal2)));
    }

    public static int[] fællesTal(int[] l1, int[] l2) {
        int[] result;
        if (l1.length > l2.length) {
            result = new int[l2.length];
        } else {
            result = new int[l1.length];
        }

        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2])
                i1++;
            else if (l1[i1] > l2[i2])
                i2++;
            else {
                result[i] = l1[i1];
                i++;
                i1++;
                i2++;
            }
        }
        return Arrays.copyOf(result, i);
    }
}

