package ATM_Machine;

public class BankAccount {
    private double balance;
    private int id;

    private static int antalKonti;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        id = antalKonti;
        antalKonti++;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
    public int getId() {
        return id;
    }

    public static int getAntalKonti(){
        return antalKonti;
    }

    public static String menu(){
        return "Main menu" + "\n1: Check balance" + "\n2: Withdraw" + "\n3: Deposit" + "\n4: Exit" + "\nEnter a choice: ";
    }
}

