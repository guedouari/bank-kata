package com.example.bankkata.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.example.bankkata.model.AccountOperations;
import com.example.bankkata.model.Amount;
import com.example.bankkata.model.OperationType;
import com.example.bankkata.model.Transaction;


public class AccountOperationsTest {

	@Test
	public void testMethodPrintAllOperations() {
		AccountOperations accountOperations= new AccountOperations();
		accountOperations.addTransaction(new Transaction(Amount.valueOf(BigDecimal.valueOf(3200)),
				LocalDate.parse("2019-11-05"), OperationType.DEPOSIT), Amount.valueOf(BigDecimal.valueOf(3200)));
		assertEquals("Operation 	Date      	Amount    	Balance   \n"+
				"DEPOSIT   	05/11/2019	3200,00   	3200,00\n", accountOperations.printAllOperations());
	}

}
