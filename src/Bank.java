import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    private User currentUser;
    private HashMap<String, User> users;

    public Bank() {
        this.currentUser = null;
        this.users = new HashMap<>();
    }

    public void registerUser(String username, String password, String name, String gender, double balance) {
        if (!users.containsKey(username)) {
            User newUser = new User(name, gender, balance);
            newUser.setUsername(username);
            newUser.setPassword(password);
            users.put(username, newUser);
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    public void loginUser(String username, String password) {
        if (currentUser == null) {
            if (users.containsKey(username)) {
                User user = users.get(username);
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    System.out.println("User logged in successfully!");
                } else {
                    System.out.println("Invalid password. Please try again.");
                }
            } else {
                System.out.println("User not found. Please try again.");
            }
        } else {
            System.out.println("Another user is already logged in. Please log out first.");
        }
    }

    public void logoutUser() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("User logged out successfully!");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void credit(double amount) {
        if (currentUser != null) {
            currentUser.setBalance(currentUser.getBalance() + amount);
            System.out.println("Amount credited successfully!");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void debit(double amount) {
        if (currentUser != null) {
            if (currentUser.getBalance() >= amount) {
                currentUser.setBalance(currentUser.getBalance() - amount);
                System.out.println("Amount debited successfully!");
            } else {
                System.out.println("Insufficient balance. Please try again.");
            }
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void showBalance() {
        if (currentUser != null) {
            System.out.println("Current balance: " + currentUser.getBalance());
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void replaceUser(String username, String password, String name, String gender, double balance) {
        if (users.containsKey(username)) {
            User newUser = new User(name, gender, balance);
            newUser.setUsername(username);
            newUser.setPassword(password);
            users.put(username, newUser);
            System.out.println("User replaced successfully!");
        } else {
            System.out.println("User not found. Please try again.");
        }
    }
}

