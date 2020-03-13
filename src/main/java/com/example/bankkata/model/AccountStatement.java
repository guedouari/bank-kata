package fr.kata.bank.model;


public class AccountStatement {
	
	private Transaction transaction;
	
	private Amount balance;

	public AccountStatement(Transaction transaction, Amount balance) {
		this.transaction = transaction;
		this.balance = balance;
	}

	public String printAccountStatement() {
		return String.format("%-10s\t%s\n", transaction.printTransaction(), balance.format());
	}

}
