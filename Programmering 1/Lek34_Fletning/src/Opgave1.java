import java.util.ArrayList;
import java.util.Random;

public class Opgave1 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>() {{
            Random random = new Random();
            String[] firstNames = {"Anders", "Anna", "Dars", "Emma", "Frederik", "Katrine", "Mads", "Maria", "Sofie", "William"};
            String[] lastNames = {"Andersen", "Christiansen", "Hansen", "Jensen", "Johansen", "Larsen", "Madsen", "Nielsen", "Pedersen", "Poulsen"};
            for (int i = 0; i < 10; i++) {
                add(new Customer(
                        firstNames[i],
                        lastNames[i],
                        random.nextInt(70) + 18 // Age between 18 and 87
                ));
            }
        }};

        ArrayList<Customer> moreCustomers = new ArrayList<>() {{
            Random random = new Random();
            String[] firstNames = {"Camilla", "Jakob", "Laura", "Line", "Louise", "Martin", "Michelle", "Peter", "Søren", "Thomas"};
            String[] lastNames = {"Bak", "Berg", "Brandt", "Jørgensen", "Lind", "Lund", "Mortensen", "Olsen", "Petersen", "Thomsen"};
            for (int i = 0; i < 10; i++) {
                add(new Customer(
                        firstNames[i],
                        lastNames[i],
                        random.nextInt(70) + 18 // Age between 18 and 87
                ));
            }
        }};

        ArrayList<Customer> flettedeKunder = fletAlleKunder(customers,moreCustomers);
        for (Customer customer : flettedeKunder) {
            System.out.println(customer.getFirstName());
        }

    }

    public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1,
                                           ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
// flet sålænge der er noget i begge lister
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).getFirstName().compareTo(l2.get(i2).getFirstName()) < 0) {
// s1's første tal er mindst
                result.add(l1.get(i1));
                i1++;
            }
            else { // s2's første tal er mindst
                result.add(l2.get(i2));
                i2++;
            }
        }
// tøm den liste der ikke er tom
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }

}

