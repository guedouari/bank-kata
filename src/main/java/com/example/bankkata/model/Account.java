package fr.kata.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import fr.kata.bank.exception.InvalidOperationException;

public class Account {
	
	private Amount balance = Amount.valueOf(BigDecimal.ZERO);
	
	private AccountOperations accountOperations;

	
	public Account() {
		accountOperations = new AccountOperations();
	}

	
	public void deposit(Amount amount, LocalDate date) throws InvalidOperationException {
		if (amount == null) {
			throw new InvalidOperationException(OperationType.DEPOSIT.name());
		}
		addOperation(amount, date, OperationType.DEPOSIT);
	}

	
	public void withdrawal(Amount amount, LocalDate date) throws InvalidOperationException {
		if (amount == null) {
			throw new InvalidOperationException(OperationType.WITHDRAWAL.name());
		}
		addOperation(amount.negate(), date, OperationType.WITHDRAWAL);
	}

	
	private void addOperation(Amount amount, LocalDate date, OperationType operationType) {
		balance = balance.add(amount);
		Transaction transaction = new Transaction(amount, date, operationType);
		accountOperations.addTransaction(transaction, balance);
	}

	public String seeHistory() {
		return accountOperations.printAllOperations();
	}

}
