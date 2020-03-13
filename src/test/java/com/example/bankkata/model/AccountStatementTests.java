package com.example.bankkata.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.bankkata.model.AccountStatement;
import com.example.bankkata.model.Amount;
import com.example.bankkata.model.OperationType;
import com.example.bankkata.model.Transaction;


public class AccountStatementTest {

	@Test
	public void testMethodprintAccountStatement() {
		Transaction transaction = new Transaction(Amount.valueOf(BigDecimal.valueOf(3500)),
				LocalDate.parse("2019-11-03"), OperationType.DEPOSIT);
		AccountStatement accountStatement = new AccountStatement(transaction, Amount.valueOf(BigDecimal.valueOf(3500)));
		String expected = String.format("%-10s\t%s\n", transaction.printTransaction(),
				Amount.valueOf(BigDecimal.valueOf(3500)).format());
		assertEquals(expected, accountStatement.printAccountStatement());

	}

}
