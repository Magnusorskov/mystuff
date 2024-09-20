public class Opgave4 {
    public static void main(String[] args) {
        starPictureb(10);
    }

    public static void starPicture(int MAX_ROWS) {

        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    // a)

    public static void starPictureTopToBottom(int n) {

        for (int MAX_ROWS = n; MAX_ROWS >= 1; MAX_ROWS--) {
            for (int star = MAX_ROWS; star >= 1; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // opgave b

    public static void starPictureb(int n) {
        int stars = 1;
        int spaces = n - stars;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            System.out.println();
            stars++;
            spaces = n - stars;
        }

    }

    // opgave c
    public static void starPictureC(int n) {

        int spaces = 0;
        int stars = n - spaces;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            System.out.println();
            spaces++;
            stars = n - spaces;
        }
    }
}
