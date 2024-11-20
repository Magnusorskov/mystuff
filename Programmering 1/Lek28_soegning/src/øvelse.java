public class øvelse {
    public static void main(String[] args) {
        String s1 = "Welcome";
        String s2 = "welcome";

        boolean isEqual = s1.equals(s2);

        isEqual = s1.equalsIgnoreCase(s2);

        int x = s1.compareTo(s2);
        System.out.println(x);

        x = s1.compareToIgnoreCase(s2);
        System.out.println(x);
    }
}
