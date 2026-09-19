package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {
    public static void main(String[] args) {
        System.out.println("=== Activity 12: Factory-Driven System Suite ===");
try {
            IAccount savings = AccountFactory.createAccount("SAVINGS", "S001", "Suman", 10000);
            IAccount current = AccountFactory.createAccount("CURRENT", "C001", "Rahul", 5000);
            IAccount fixedDeposit = AccountFactory.createAccount("FIXEDDEPOSIT", "F001", "Aman", 20000);

            System.out.println("\n--- Accounts Created Successfully ---");
            System.out.println("Savings Account: " + savings);
            System.out.println("Current Account: " + current);
            System.out.println("Fixed Deposit Account: " + fixedDeposit);

            System.out.println("\n--- Deposit and Withdrawal Tests ---");

            savings.deposit(2000);
            System.out.println("Savings balance after deposit: " + savings.getBalance());

            savings.withdraw(1000);
            System.out.println("Savings balance after withdrawal: " + savings.getBalance());

            current.deposit(3000);
            System.out.println("Current balance after deposit: " + current.getBalance());

            current.withdraw(2000);
            System.out.println("Current balance after withdrawal: " + current.getBalance());

            System.out.println("\n--- Savings Minimum Balance Test ---");

            try {
                savings.withdraw(10000);
                System.out.println("ERROR: Savings minimum balance rule was not enforced.");
            } catch (Exception e) {
                System.out.println("PASS: Savings minimum balance rule enforced.");
                System.out.println("Message: " + e.getMessage());
            }

            System.out.println("\n--- Current Overdraft Limit Test ---");

            try {
                current.withdraw(10000);
                System.out.println("ERROR: Current overdraft limit was not enforced.");
            } catch (Exception e) {
                System.out.println("PASS: Current overdraft limit enforced.");
                System.out.println("Message: " + e.getMessage());
            }

            System.out.println("\n--- Fixed Deposit Premature Withdrawal Test ---");

            try {
                fixedDeposit.withdraw(5000);
                System.out.println("ERROR: Fixed Deposit premature withdrawal was not rejected.");
            } catch (Exception e) {
                System.out.println("PASS: Fixed Deposit premature withdrawal rejected.");
                System.out.println("Message: " + e.getMessage());
            }

            System.out.println("\n--- Invalid Account Type Test ---");

            try {
                IAccount invalid = AccountFactory.createAccount(
                        "INVALID",
                        "X001",
                        "Test User",
                        5000
                );

                System.out.println("ERROR: Invalid account type was accepted.");

            } catch (IllegalArgumentException e) {
                System.out.println("PASS: Invalid account type correctly rejected.");
                System.out.println("Message: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("\nTest suite encountered an error:");
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Activity 12 test suite completed ===");
    }
}
        // NOTE: If you completed Activity 11 successfully, paste your working IAccount.java and AccountFactory.java into src/com/gdb/domain (replacing the provided versions).

        // TODO: Step 1 - Instantiate Savings, Current, and FixedDeposit accounts exclusively through AccountFactory.createAccount()

        // TODO: Step 2 - Perform deposits and withdrawals through the IAccount interface references

        // TODO: Step 3 - Verify Savings minimum balance rule enforcement through the interface

        // TODO: Step 4 - Verify Current overdraft limit enforcement through the interface

        // TODO: Step 5 - Verify FixedDeposit premature withdrawal rejection through the interface

        // TODO: Step 6 - Verify requesting an invalid account type from AccountFactory throws IllegalArgumentException

        System.out.println("=== Complete Activity 12 test suite and run ===");
    }
}
