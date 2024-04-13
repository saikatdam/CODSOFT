import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + account.checkBalance());
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        System.out.println("Withdrawal successful. Current balance: " + account.checkBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.checkBalance());
    }
}

public class atmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        while(true) {
            System.out.println("Choose an option: \n1. Deposit \n2. Withdraw \n3. Check Balance \n4. Exit");
            int option = scanner.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
