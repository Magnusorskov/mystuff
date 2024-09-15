

public class Opgave3 {

    public static void main(String[] args) {
        printMatrix(10);
    }

    public static void printMatrix(int n) {


        for (int i = 1; i <= n;) {
            for (int j = 1; j <=n; j++) {
                int number = (int) (Math.random() * 2);
                System.out.print(number + " ");
            }
            System.out.println();i++;

        }
    }
}
