package com.bank;

import com.bank.service.AccountService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();
        int choice;

        do {
            System.out.println("\n===== MINI BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Login (to verify password)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    service.createAccount(name, email, pass, bal);
                    break;
                case 2:
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double dep = sc.nextDouble();
                    service.deposit(email, dep);
                    break;
                case 3:
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double wd = sc.nextDouble();
                    service.withdraw(email, wd);
                    break;
                case 4:
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    service.showBalance(email);
                    break;
                case 5:
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pw = sc.nextLine();
                    boolean ok = service.authenticate(email, pw);
                    System.out.println(ok ? "✅ Authentication successful" : "❌ Authentication failed");
                    break;
                case 6:
                    System.out.println("👋 Thank you for using Mini Banking System!");
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}
