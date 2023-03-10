import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the bank!");

        try {

            do {
                System.out.println("What would you like to do?");
                System.out.println("1. Register user");
                System.out.println("2. Log in user");
                System.out.println("3. Log out user");
                System.out.println("4. Credit account");
                System.out.println("5. Debit account");
                System.out.println("6. Show balance");
                System.out.println("7. Replace user");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.next();
                        System.out.print("Enter password: ");
                        String password = scanner.next();
                        System.out.print("Enter full name: ");
                        String name = scanner.next();
                        scanner.nextLine();
                        System.out.print("Enter gender: ");
                        String gender = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double balance = scanner.nextDouble();
                        bank.registerUser(username, password, name, gender, balance);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        username = scanner.next();
                        System.out.print("Enter password: ");
                        password = scanner.next();
                        bank.loginUser(username, password);
                        break;
                    case 3:
                        bank.logoutUser();
                        break;
                    case 4:
                        System.out.print("Enter amount to credit: ");
                        double amount = scanner.nextDouble();
                        bank.credit(amount);
                        break;
                    case 5:
                        System.out.print("Enter amount to debit: ");
                        amount = scanner.nextDouble();
                        bank.debit(amount);
                        break;
                    case 6:
                        bank.showBalance();
                        break;
                    case 7:
                        System.out.print("Enter username: ");
                        username = scanner.next();
                        System.out.print("Enter password: ");
                        password = scanner.next();
                        System.out.print("Enter name: ");
                        name = scanner.next();
                        System.out.print("Enter gender: ");
                        gender = scanner.next();
                        System.out.print("Enter initial balance: ");
                        balance = scanner.nextDouble();
                        bank.replaceUser(username, password, name, gender, balance);
                        break;
                    case 8:
                        System.out.println("Thank you for banking with us!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 8);

            scanner.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}



