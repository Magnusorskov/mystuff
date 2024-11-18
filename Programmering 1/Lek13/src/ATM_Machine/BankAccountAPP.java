package ATM_Machine;

import java.util.Scanner;

public class BankAccountAPP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankAccount[] bankAccounts = new BankAccount[10];

        for (int i = 0; i < bankAccounts.length; i++) {
            bankAccounts[i] = new BankAccount(100);
        }



        boolean access = false;


        while (true) {
            System.out.println("Enter your bank account ID: ");
            int ID = scan.nextInt();
            while (!access) {
                for (int i = 0; i < bankAccounts.length; i++) {
                    if (ID == bankAccounts[i].getId()) {
                        access = true;
                    }
                    if (i == bankAccounts.length - 1 && !access) {
                        System.out.println("No ID recognized, type your ID: ");
                        ID = scan.nextInt();
                    }
                }
            }
            System.out.println("Welcome User with ID = " + ID);
            System.out.println(BankAccount.menu());

            int choice = scan.nextInt();
            while (choice != 4) {
                if (choice == 1) {
                    System.out.println(bankAccounts[ID].getBalance());
                } else if (choice == 2) {
                    System.out.println("How much would you like to withdraw? ");
                    bankAccounts[ID].withdraw(scan.nextDouble());
                } else {
                    System.out.println("How much would you like to deposit? ");
                    bankAccounts[ID].deposit(scan.nextDouble());
                }
                System.out.println(BankAccount.menu());
                choice = scan.nextInt();
            }
            System.out.println("Goodbye!");
            access = false;
            }
        }
    }



