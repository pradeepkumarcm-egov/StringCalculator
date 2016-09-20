package org.egov.bootcamp;

import java.util.Arrays;
import java.util.List;

import org.egov.bootcamp.exception.InValidInputException;

public class StringCalculator {
	private final String valid_pattern = "^\\d+(?>\\+\\d+)*$";

	public int calculate(String expression) {
		expression = expression.replaceAll("\\s", "");
		if (!expression.matches(valid_pattern))
			throw new InValidInputException();

		List<String> operands = Arrays.asList(expression.split("\\+"));
		return operands.stream()
				.map((operand) -> Integer.parseInt(operand))
				.mapToInt(Integer::intValue).sum();
	}
}
