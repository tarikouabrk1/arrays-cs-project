package samplearrays;
public class BankAccount {

    private String name;
    private double currentBalance;
    private double[] transactions = new double[1000];
    private int numOfTransactions = 0;

    public BankAccount(String name, int startingBalance) {
        this.name = name;
        this.currentBalance = startingBalance;
        System.out.println("Account created for " + name + " with starting balance: " + startingBalance);
        System.out.println("--------------------------------------------");
    }

    public void deposit(double amount) {
        System.out.println("Deposit request: " + amount);

        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be positive.");
            System.out.println();
            return;
        }
        if (numOfTransactions >= transactions.length) {
            System.out.println("Deposit failed: transaction limit reached.");
            System.out.println();
            return;
        }

        currentBalance += amount;
        transactions[numOfTransactions] = amount;
        numOfTransactions++;

        System.out.println(name + " deposited " + amount + ". New balance is " + currentBalance);
        System.out.println();
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawal request: " + amount);

        if (amount <= 0) {
            System.out.println("Withdrawal failed: amount must be positive.");
            System.out.println();
            return;
        }
        if (amount > currentBalance) {
            System.out.println("Withdrawal failed: insufficient balance.");
            System.out.println();
            return;
        }
        if (numOfTransactions >= transactions.length) {
            System.out.println("Withdrawal failed: transaction limit reached.");
            System.out.println();
            return;
        }

        currentBalance -= amount;
        transactions[numOfTransactions] = -amount;
        numOfTransactions++;

        System.out.println(name + " withdrew " + amount + ". New balance is " + currentBalance);
        System.out.println();
    }

    public void displayTransactions() {
        System.out.println("Transaction history for " + name + ":");
        System.out.println("--------------------------------------------");

        if (numOfTransactions == 0) {
            System.out.println("No transactions recorded yet.");
            System.out.println();
            return;
        }

        double totalDeposits = 0;
        double totalWithdrawals = 0;

        for (int i = 0; i < numOfTransactions; i++) {
            double t = transactions[i];
            if (t > 0) {
                System.out.println("Deposit of " + t);
                totalDeposits += t;
            } else if (t < 0) {
                System.out.println("Withdrawal of " + (-t));
                totalWithdrawals += (-t);
            }
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total deposited: " + totalDeposits);
        System.out.println("Total withdrawn: " + totalWithdrawals);
        System.out.println();
    }

    public void displayBalance() {
        System.out.println("Current balance for " + name + ": " + currentBalance);
        System.out.println();
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();
        // ----- DO NOT CHANGE -----
    }
}

