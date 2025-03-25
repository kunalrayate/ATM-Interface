package com.ATM;

import java.util.Scanner;

class ATM {
	private double balance;

	public ATM(double initialBalance) {
		this.balance = initialBalance;
	}

	public void checkBalance() {
		System.out.println("Balance: " + balance);
	}

	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
		System.out.println(amount > 0 ? "Deposited: " + amount : "Invalid amount.");
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
		} else
			System.out.println(amount > balance ? "Insufficient balance." : "Invalid amount.");
	}
}

public class ATMInterface {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ATM atm = new ATM(1000);

		while (true) {
			System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			if (choice == 4)
				break;
			if (choice == 1)
				atm.checkBalance();
			else if (choice == 2) {
				System.out.print("Enter deposit amount: ");
				atm.deposit(scanner.nextDouble());
			} else if (choice == 3) {
				System.out.print("Enter withdrawal amount: ");
				atm.withdraw(scanner.nextDouble());
			} else
				System.out.println("Invalid option.");
		}
		System.out.println("Thank you for using our ATM.");
		scanner.close();
	}
}
