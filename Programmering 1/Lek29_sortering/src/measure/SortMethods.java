package measure;

import model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortMethods {
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swapCustomer(ArrayList<Customer> customers, int i, int j) {
        Customer temp = customers.get(i);
        customers.set(i, customers.get(j));
        customers.set(j, temp);
    }


    public static void bubbleSort(String[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j + 1);
            }
        }
    }

    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.charAt(0) >= array[j - 1].charAt(0)) {
                    found = true;
                } else {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = next;
        }
    }

    public static void insertionSortCustomer(ArrayList<Customer> list) {
        for (int i = 1; i < customers.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getFirstName().charAt(0) >= list.get(j - 1).getFirstName().charAt(0)) {
                    found = true;
                } else {
                    customers.set(j,customers.get(j-1));
                    j--;
                }
            }
            list.set(j,next);
        }
    }

    // string array
    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }

            }
            swap(array, i, minPos);
        }
    }

    // customer array
    public static void selectionSortCustomer(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getFirstName().charAt(0) < list.get(minPos).getFirstName().charAt(0)) {
                    minPos = j;
                }

            }
            swapCustomer(list, i, minPos);
        }
    }

    static ArrayList<Customer> customers = new ArrayList<>() {{
        Random random = new Random();
        String[] firstNames = {"Anna", "Emma", "Mads", "Lars", "Sofie", "William", "Frederik", "Maria", "Anders", "Katrine"};
        String[] lastNames = {"Jensen", "Hansen", "Nielsen", "Larsen", "Andersen", "Pedersen", "Christiansen", "Madsen", "Johansen", "Poulsen"};
        for (int i = 0; i < 10; i++) {
            add(new Customer(
                    firstNames[random.nextInt(firstNames.length)],
                    lastNames[random.nextInt(lastNames.length)],
                    random.nextInt(70) + 18 // Age between 18 and 87
            ));
        }
    }};

    public static void main(String[] args) {
//        selectionSortCustomer(customers);
        insertionSortCustomer(customers);
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        ArrayList<String> list = new ArrayList<String>();
        list.add("Dane");
        list.add("Bent");
        list.add("Thomas");
        list.add("Karsten");
        list.add("Dann");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

}
    

