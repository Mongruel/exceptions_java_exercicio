package application;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.DomainException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();

		Account account = new Account(number, holder, initialBalance, withdrawLimit);

		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		try {
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected exception.");
		}
		sc.close();
	}
}