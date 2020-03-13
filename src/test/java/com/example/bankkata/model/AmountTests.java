package com.example.bankkata.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.example.bankkata.model.Amount;


public class AmountTests {

	@Test
	public void exceptionShouldBeThrownWhenValueIsNull() {
		Amount amount = new Amount(null);
		assertEquals(new Amount(BigDecimal.ZERO), amount);
	}
	

	@Test
	public void amountShouldBeCreatedWhenValueIsNotNull() {
		Amount amount = new Amount(BigDecimal.valueOf(500.36));
		assertNotNull(amount);
	}

	@Test
	public void testMethodAddNonNullValueOfAmount() {
		Amount amount = new Amount(BigDecimal.valueOf(1200.50));
		Amount otherAmount = new Amount(BigDecimal.valueOf(300.25));
		Amount newAmount = amount.add(otherAmount);
		
		assertEquals(new Amount(BigDecimal.valueOf(1500.75)), newAmount);
	}

	@Test
	public void testMethodAddNullValueOfAmount() {
		Amount amount = new Amount(BigDecimal.valueOf(1200.50));
		Amount newAmount = amount.add(null);
		
		assertEquals(new Amount(BigDecimal.valueOf(1200.50)), newAmount);
	}

	@Test
	public void testMethodNegate() {
		Amount amount = new Amount(BigDecimal.valueOf(1200));
		assertEquals(new Amount(BigDecimal.valueOf(-1200)), amount.negate());
		amount = new Amount(BigDecimal.valueOf(-1200));
		assertEquals(new Amount(BigDecimal.valueOf(-1200)), amount.negate());
	}
	

	@Test
	public void testMeThodFormat() {
		Amount amount = new Amount(BigDecimal.valueOf(300.568));
		assertEquals("300,57", amount.format());
	}

}
