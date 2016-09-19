package org.egov.bootcamp;

import java.util.regex.Pattern;

import org.egov.bootcamp.exception.InValidInputException;

public class StringCalculator {
	Pattern pattern = Pattern.compile("^([0-9])+|([0-9][+][0-9])+$");
	
	public int calculate(String expression) {
		expression = expression.trim();
		if (!Pattern.matches(pattern.pattern(), expression))
			throw new InValidInputException();
		return Integer.parseInt(expression);
	}
}
