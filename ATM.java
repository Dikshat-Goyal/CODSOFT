import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }
        }
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your current balance is: $" + balance);
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
            return;
        }

        userAccount.deposit(amount);
        System.out.println("$" + amount + " has been deposited into your account.");
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
            return;
        }

        if (userAccount.getBalance() < amount) {
            System.out.println("Insufficient funds. Withdrawal cannot be processed.");
            return;
        }

        userAccount.withdraw(amount);
        System.out.println("$" + amount + " has been withdrawn from your account.");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // consume invalid input
        }
        return scanner.nextInt();
    }

    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // consume invalid input
        }
        return scanner.nextDouble();
    }
}
