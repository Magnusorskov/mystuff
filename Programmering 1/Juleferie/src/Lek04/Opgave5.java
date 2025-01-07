package Lek04;

public class Opgave5 {
    public static void main(String[] args) {
        System.out.println(team(true, 3));
    }

    private static String team(boolean isBoy, int age) {
        String s;

        if (age >= 8) {
            if (isBoy) {
                s = "Cool boys";
            } else {
                s = "Springy girls";
            }
        } else if (isBoy) {
            s = "Young cubs";
        } else {
            s = "Tumbling girls";
        }
        return s;
    }
}
