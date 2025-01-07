package Lek04;

public class Opgave6 {
    public static void main(String[] args) {
    }

    private static String sign (int tal) {
        String s;
        if (tal < 0) {
            s = "Negativ";
        } else if (tal == 0) {
            s = "Nul";
        } else {
            s = "Positiv";
        }
        return s;
    }
}
