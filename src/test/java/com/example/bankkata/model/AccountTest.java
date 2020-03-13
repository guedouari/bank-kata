package com.example.bankkata.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bankkata.model.Account;
import com.example.bankkata.model.AccountOperations;
import com.example.bankkata.model.Amount;
import com.example.bankkata.model.OperationType;
import com.example.bankkata.model.Transaction;

import com.example.bankkata.rest.exception.InvalidOperationException;

public class AccountTest {

	@Mock
	private AccountOperations accountOperations;

	@InjectMocks
	private Account account;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMethodDeposit() throws InvalidOperationException {
		account.deposit(Amount.valueOf(BigDecimal.valueOf(1200)), LocalDate.parse("2019-11-05"));
		Mockito.verify(accountOperations).addTransaction(new Transaction(Amount.valueOf(BigDecimal.valueOf(1200)),
				LocalDate.parse("2019-11-05"), OperationType.DEPOSIT), Amount.valueOf(BigDecimal.valueOf(1200)));
	}

	@Test
	public void testMethodDepositWithNullValueOfAmount() {
		assertThrows(InvalidOperationException.class, () -> {
			account.deposit(null, LocalDate.parse("2019-11-05"));
		});
	}

	@Test
	public void testMethodWithdrawal() throws InvalidOperationException {
		account.withdrawal(Amount.valueOf(BigDecimal.valueOf(200)), LocalDate.parse("2019-11-05"));
		Mockito.verify(accountOperations).addTransaction(new Transaction(Amount.valueOf(BigDecimal.valueOf(-200)),
				LocalDate.parse("2019-11-05"), OperationType.WITHDRAWAL), Amount.valueOf(BigDecimal.valueOf(-200)));

	}

	@Test
	public void testMethodWithdrawalWithNullValueOfAmount() {
		assertThrows(InvalidOperationException.class, () -> {
			account.withdrawal(null, LocalDate.parse("2019-11-05"));
		});

	}

	@Test
	public void testMethodSeeHistory() throws InvalidOperationException {
		account.deposit(Amount.valueOf(BigDecimal.valueOf(3200)), LocalDate.parse("2019-11-05"));
		Mockito.when(accountOperations.printAllOperations()).thenReturn(
				"Operation 	Date      	Amount    	Balance   \r\n" + "DEPOSIT   	05/11/2019	3200,00    	3200,00");
		assertEquals(
				"Operation 	Date      	Amount    	Balance   \r\n" + "DEPOSIT   	05/11/2019	3200,00    	3200,00",
				account.seeHistory());

	}
}
