package com.example.bankkata.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.bankkata.model.Amount;
import com.example.bankkata.model.OperationType;
import com.example.bankkata.model.Transaction;

public class TransactionTests {

	@Test
	public void testMethodPrintTransaction() {
		Transaction transaction = new Transaction(Amount.valueOf(BigDecimal.valueOf(3500)),
				LocalDate.parse("2019-11-03"), OperationType.DEPOSIT);
		String expected = String.format("%-10s\t%-10s\t%-10s", OperationType.DEPOSIT, "03/11/2019",
				Amount.valueOf(BigDecimal.valueOf(3500)).format());
		assertEquals(expected, transaction.printTransaction());

	}
}
