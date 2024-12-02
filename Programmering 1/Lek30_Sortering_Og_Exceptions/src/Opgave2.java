import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Opgave2 {
    public static void main(String[] args) {
        Customer[] customers = new Customer[] {
                new Customer("Alice", "Johnson", 28),
                new Customer("Bob", "Smith", 34),
                new Customer("Charlie", "Adams", 23),
                new Customer("Diana", "Brown", 45),
                new Customer("Edward", "Clark", 31),
                null
        };
       Customer customer1 = new Customer("Cean","blab",30);
        insertCustomer(customers,customer1);
        System.out.println(Arrays.toString(customers));

    }

    public static void insertCustomer(Customer[] customers, Customer customer){
        int j = customers.length-1;
        while(j>=0 && customers[j]==null) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j > 0) {
            if (customers[j-1].getFirstName().compareTo(customer.getFirstName()) < 0) {
                found = true;
            }
            else {
                customers[j] = customers[j-1];
                j--;
            }
        }
        customers[j] = customer;
    }


}
