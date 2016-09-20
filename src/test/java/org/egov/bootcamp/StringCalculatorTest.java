package org.egov.bootcamp;

import static junit.framework.TestCase.assertEquals;

import org.egov.bootcamp.exception.InValidInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowNullPointerExceptionIfInputIsNull() throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(NullPointerException.class);
		calculator.calculate(null);
	}

	@Test
	public void shouldThrowInValidInputExceptionIfInputIsEmpty()
			throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("");
	}

	@Test
	public void shouldThrowInValidInputExceptionIfInputIsEmptyWithSpaces()
			throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("            ");
	}

	@Test
	public void shouldRetrunSameValueIfInputIsWithOutOperator()
			throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.calculate("1"));
	}

	@Test
	public void shouldRetrunSameValueIfInputIsWithOutOperatorWithSpaces()
			throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.calculate("    1      "));
	}

	@Test
	public void shouldThrowInvalidInputExceptionIfInputPatternIsInvalid()
			throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("1((((2");
		thrown.expect(InValidInputException.class);
		calculator.calculate("%%^&%((((2");
		thrown.expect(InValidInputException.class);
		calculator.calculate("1+");
		thrown.expect(InValidInputException.class);
		calculator.calculate("  1   2  ");

	}

	@Test
	public void shouldReturnAppropriateValueOnAddittion() {
		StringCalculator calculator = new StringCalculator();

		assertEquals(10, calculator.calculate("1+9"));
		assertEquals(10, calculator.calculate(" 1+9"));
		assertEquals(10, calculator.calculate("1    +9"));
		assertEquals(10, calculator.calculate("1+ 9"));
		assertEquals(27, calculator.calculate("1+9+9+8 "));
		assertEquals(10, calculator.calculate("    1    +     9    "));
	}



}
