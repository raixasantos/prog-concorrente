package trabalho02.src.numberecalculator;

import java.math.BigDecimal;

public class NumbereCalculator {
    
    /** 
     * Sum of divisions from 1 factorial with 0 to n.
     * @param factorial Number of factorial.
     * @param sum Previous sum value.
     * @return BigDecimal Result of new sum.
     */
    public BigDecimal sumFactorial(BigDecimal factorial, BigDecimal sum) {
        return sum.add(factorial);
    }
}
