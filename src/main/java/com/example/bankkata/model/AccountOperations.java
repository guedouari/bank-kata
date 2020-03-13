package com.example.bankkata.model;

import java.util.LinkedList;
import java.util.List;


public class AccountOperations {
	
	private static final String HEADER = String.format("%-10s\t%-10s\t%-10s\t%-10s\n", "Operation", "Date", "Amount",
			"Balance");

	
	private List<AccountStatement> transactions = new LinkedList<>();

	
	public void addTransaction(Transaction transaction, Amount balance) {
		transactions.add(0, new AccountStatement(transaction, balance));
	}

	
	public String printAllOperations() {
		StringBuilder output = new StringBuilder(HEADER);
		transactions.stream().forEach(item -> output.append(item.printAccountStatement()));
		return output.toString();
	}
}
