package Name;

public class NameApp {
    public static void main(String[] args) {
        Name n1 = new Name("Zagnus", "Tolstrup", "Dammeyer");
        System.out.println(n1.getFullName());
        System.out.println(n1.getInit());
        System.out.println(n1.getUsername());

        System.out.println(n1.getCryptoINIT(1));
    }

}
