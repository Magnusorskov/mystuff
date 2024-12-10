import java.util.ArrayList;
import java.util.Random;

public class
Opgave1    {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>() {{
            Random random = new Random();
            String[] firstNames = {"Anna", "Bmma", "Cads", "Dars", "Eofie", "Filliam", "Frederik", "Garia", "Hnders", "Katrine"};
            String[] lastNames = {"Jensen", "Hansen", "Nielsen", "Larsen", "Andersen", "Pedersen", "Christiansen", "Madsen", "Johansen", "Poulsen"};
            for (int i = 0; i < 10; i++) {
                add(new Customer(
                        firstNames[i],
                        lastNames[i],
                        random.nextInt(70) + 18 // Age between 18 and 87
                ));
            }
        }};
        Customer customerBla = new Customer("Elias","Hem",30);
        insertCustomer(customers,customerBla);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static void insertCustomer(ArrayList<Customer> customers, Customer customer){
        boolean found = false;
        int i = 0;;
        while (!found && i<customers.size()) {
            if (customers.get(i).getFirstName().compareTo(customer.getFirstName()) > 0) {
                found = true;
            }
            else {
                i++;
            }
        }
        customers.add(i,customer);
        }
}
