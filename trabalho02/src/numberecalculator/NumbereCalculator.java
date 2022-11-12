package trabalho02.src.numberecalculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class NumbereCalculator {
    public BigDecimal sumFactorial(BigDecimal factorial, BigDecimal sum) {
        BigDecimal value = new BigDecimal(1);
        return sum.add(value.divide(factorial, MathContext.DECIMAL128));
    }
}
