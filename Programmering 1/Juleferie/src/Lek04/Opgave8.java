package Lek04;

public class Opgave8 {
    public static void main(String[] args) {

    }

    private static String årstid(int måned, int dag) {
        String s = null;

        if (måned < 4) {
            s = "Vinter";
        } else if (måned < 7) {
            s = "Forår";
        } else if (måned < 10) {
            s = "Sommer";
        } else {
            s = "Efterår";
        }
        if (dag % 3 == 0 && dag >= 21) {
            if (s.equals("Vinter")) {
                s = "Forår";
            } else if (s.equals("Forår")) {
                s = "Sommer";
            } else if (s.equals("Sommer")) {
                s = "Efterår";
            } else {
                s = "Vinter";
            }
        }
        return s;
    }
}
