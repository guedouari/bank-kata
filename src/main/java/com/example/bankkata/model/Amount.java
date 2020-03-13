package com.example.bankkata.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.ObjectUtils;


public class Amount {
	
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	
	private BigDecimal value;

	
	public Amount(BigDecimal value) {
		this.value = ObjectUtils.defaultIfNull(value, BigDecimal.ZERO) ;
	}


	public static Amount valueOf(BigDecimal value) {
		return new Amount(value);
	}


	public Amount add(Amount other) {
		if (other == null) {
			return this;
		}
		return valueOf(value.add(other.value));
	}


	public Amount negate() {
		if (value.compareTo(BigDecimal.ZERO) == -1) {
			return this;
		}
		return valueOf(value.negate());
	}


	public String format() {
		return DECIMAL_FORMAT.format(value);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Amount other = (Amount) obj;
        return ObjectUtils.equals(value, other.value);
	}

}
