package MiniBankingSystem;

import java.sql.*;
import java.util.Scanner;

public class MainMenu {
    private static final String URL = "jdbc:mysql://localhost:3306/bankserver";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MINI BANKING SYSTEM ===");
            System.out.println("1. Create User");
            System.out.println("2. View User");
            System.out.println("3. Update User Email");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> createUser(sc);
                case 2 -> viewUser(sc);
                case 3 -> updateUserEmail(sc);
                case 4 -> deleteUser(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // 1. CREATE
    private static void createUser(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String acc = sc.nextLine();
        System.out.print("Enter Username: ");
        String uname = sc.nextLine();
        System.out.print("Enter Password: ");
        String hash = SecurityUtil.hashPassword(sc.nextLine());
        System.out.print("Enter Full Name: ");
        String full = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO user (acc_no, username, password_hash, full_name, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, acc);
            ps.setString(2, uname);
            ps.setString(3, hash);
            ps.setString(4, full);
            ps.setString(5, email);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "User Created" : "Failed to create user");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. READ
    private static void viewUser(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String acc = sc.nextLine();

        String sql = "SELECT * FROM user WHERE acc_no = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, acc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Full Name: " + rs.getString("full_name"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("No user found with account number " + acc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. UPDATE
    private static void updateUserEmail(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String acc = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        String sql = "UPDATE user SET email = ? WHERE acc_no = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, acc);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Email updated" : "Account not found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. DELETE
    private static void deleteUser(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String acc = sc.nextLine();

        String sql = "DELETE FROM user WHERE acc_no = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, acc);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "User deleted" : "Account not found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
