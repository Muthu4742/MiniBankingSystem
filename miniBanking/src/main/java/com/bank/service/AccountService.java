package com.bank.service;

import com.bank.dao.AccountDAO;
import com.bank.entity.Account;
import java.security.MessageDigest;

public class AccountService {
    private AccountDAO dao = new AccountDAO();

    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public boolean authenticate(String email, String password) {
        try {
            Account acc = dao.getAccountByEmail(email);
            if (acc == null) return false;
            String hashed = hashPassword(password);
            return acc.getPassword().equals(hashed);
        } catch (Exception e) {
            return false;
        }
    }

    public void createAccount(String name, String email, String password, double balance) {
        try {
            if (dao.getAccountByEmail(email) != null) {
                System.out.println("⚠️ An account with this email already exists.");
                return;
            }
            String hashed = hashPassword(password);
            Account acc = new Account(name, email, hashed, balance);
            dao.saveAccount(acc);
            System.out.println("✅ Account created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit(String email, double amount) {
        Account acc = dao.getAccountByEmail(email);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
            dao.updateAccount(acc);
            System.out.println("💰 Deposited: " + amount);
        } else {
            System.out.println("⚠️ Account not found!");
        }
    }

    public void withdraw(String email, double amount) {
        Account acc = dao.getAccountByEmail(email);
        if (acc != null && acc.getBalance() >= amount) {
            acc.setBalance(acc.getBalance() - amount);
            dao.updateAccount(acc);
            System.out.println("🏧 Withdrawn: " + amount);
        } else {
            System.out.println("⚠️ Insufficient balance or invalid account!");
        }
    }

    public void showBalance(String email) {
        Account acc = dao.getAccountByEmail(email);
        if (acc != null)
            System.out.println("💳 Balance: ₹" + acc.getBalance());
        else
            System.out.println("⚠️ Account not found!");
    }
}
