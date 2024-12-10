import java.util.ArrayList;

public class Opgave3 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>() {{
            add(new Customer("Anders", "Andersen", 25));
            add(new Customer("Bolette", "Christensen", 31));
            add(new Customer("David", "Hansen", 42));
            add(new Customer("Emma", "Jensen", 28));
            add(new Customer("Frederik", "Nielsen", 35));
            add(new Customer("Gitte", "Olsen", 22));
            add(new Customer("Hans", "Pedersen", 51));
            add(new Customer("Ida", "Petersen", 29));
        }};

        Customer[] badCustomers = {
                new Customer("Anders", "Andersen", 25), // Samme som i ArrayList
                new Customer("Benjamin", "Bertelsen", 33),
                new Customer("David", "Hansen", 42), // Samme som i ArrayList
                new Customer("Emma", "Jensen", 28), // Samme som i ArrayList
                new Customer("Fie", "Fischer", 26),
                new Customer("Gitte", "Olsen", 22) // Samme som i ArrayList
        };

        System.out.println(goodCustomers(customers, badCustomers));
    }

    public static ArrayList goodCustomers(ArrayList<Customer> l1,
                                          Customer[] l2) {
        ArrayList<Customer> goodCustomers = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) < 0) {
                goodCustomers.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) > 0) {
                i2++;

            } else {
                i1++;
                i2++;
            }
        }
        while (i1 < l1.size()) {
            goodCustomers.add(l1.get(i1));
            i1++;
        }
        return goodCustomers;
    }
}
