package javaconcurrencyutilities.NumbereCalculator;

import java.math.BigDecimal;
import java.util.concurrent.Callable;


public class NumbereCalculator implements Callable<BigDecimal> {
	private BigDecimal number;

	/**
	 * Parameterized constructor
	 * @param number Number to calculate factorial
	 */
	public NumbereCalculator(BigDecimal number) {
		this.number = number;
	}

	/**
	 * Task to run upon a thread
	 * @return Factorial of a given number
	 */
	@Override
	public BigDecimal call() {
		return factorial(this.number);
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


