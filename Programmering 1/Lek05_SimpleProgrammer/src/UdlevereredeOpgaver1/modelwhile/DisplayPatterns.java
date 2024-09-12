package UdlevereredeOpgaver1.modelwhile;

public class DisplayPatterns {
    public static void main(String[] args) {
        displayPattern(12);
    }

    public static void displayPattern (int n) {
        int i = 1;

        while (i <= n) {
            int z = i;
            while (z > 0) {
                System.out.print(z);
                System.out.print(" ");
                z--;
            }
            System.out.println();
            i++;
        }

    }
}
