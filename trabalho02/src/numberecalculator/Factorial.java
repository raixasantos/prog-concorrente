package trabalho02.src.numberecalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.Callable;


public class Factorial implements Callable<BigDecimal> {
	private BigDecimal number;

	/**
	 * Parameterized constructor
	 * @param number Number to calculate factorial
	 */
	public Factorial(BigDecimal number) {
		this.number = number;
	}

	/**
	 * Task to run upon a thread
	 * @return Number with 1 divided by factorial of a given number
	 */
	@Override
	public BigDecimal call() {
		BigDecimal value = new BigDecimal(1);
		BigDecimal factorial = factorial(this.number);
		return value.divide(factorial, MathContext.DECIMAL128);
	}

	/**
	 * Recursively calculates factorial of a given number
	 * @param number Number to calculate factorial
	 * @return Factorial of the number
	 */
	private BigDecimal factorial(BigDecimal number) {
		BigDecimal value = new BigDecimal(1);
		if (value.compareTo(number) == 1 || value.compareTo(number) == 0) {
			return value;
		} else {
			return number.multiply(factorial(number.subtract(value)));
		}
	}
}
