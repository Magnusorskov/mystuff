package Lek04;

public class Opgave4 {
    public static void main(String[] args) {
        System.out.println(institution(0));
    }

    private static String institution(int alder) {
        String s;
        if (alder < 0) {
            s = "not born";
        } else if (alder == 0) {
            s = "at home";
        } else if (alder < 3) {
            s = "in nursery";
        } else if (alder < 6) {
            s = "in kindergarten";
        } else if (alder < 17) {
            s = "in school";
        } else {
            s = "out of school";
        }
        return "Your child should be " + s;
    }
}
