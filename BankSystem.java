import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem {

    static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    static class BankAccount {
        private String accountHolderName;
        private double balance;

        public BankAccount(String accountHolderName) {
            this.accountHolderName = accountHolderName;
            this.balance = 0.0;
        }

        public void deposit(double amount) throws InvalidAmountException {
            if (amount <= 0) {
                throw new InvalidAmountException("Deposit amount must be positive!");
            }
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        }

        public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
            if (amount <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be positive!");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Withdrawal failed! Insufficient balance.");
            }
            balance -= amount;
            System.out.println("Successfully withdrew: ₹" + amount);
        }

        public void viewBalance() {
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        try {
            System.out.println("Welcome to Online Bank Account Management System!");

            System.out.print("Enter account holder's name: ");
            String name = scanner.nextLine();
            account = new BankAccount(name);

            boolean exit = false;
            while (!exit) {
                System.out.println("\n----- Menu -----");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. View Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");

                int choice = 0;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input! Please enter a number between 1 and 4.");
                    scanner.next();
                    continue;
                }

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid input! Please enter a numeric value.");
                            scanner.next(); // clear wrong input
                        } catch (InvalidAmountException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid input! Please enter a numeric value.");
                            scanner.next(); 
                        } catch (InvalidAmountException | InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        account.viewBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using our banking system!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1 and 4.");
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nProgram terminated.");
        }
    }
}
