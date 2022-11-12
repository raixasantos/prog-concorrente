package trabalho02.src.workstealing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.lang.Thread;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import trabalho02.src.handleinput.HandleInput;
import trabalho02.src.numberecalculator.*;

public final class Main {
    
    /**
     * Calculate the Euler's number with Work Stealing Thread Pool.
     * @param args The arguments of the program.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num_terms = HandleInput.handleArgsInput(args)[0];

        ExecutorService executor =
            Executors.newWorkStealingPool();

        List<Future<BigDecimal>> results = new ArrayList<>();
        
        for (int i = 0; i < num_terms; i++) {
            Callable<BigDecimal> term = new Factorial(new BigDecimal(i));
            Future<BigDecimal> factorial = executor.submit(term);
            results.add(factorial);
        }
        
        try {
            NumbereCalculator numbereCalculator = new NumbereCalculator();
            BigDecimal sum = new BigDecimal(0);
            for(Future<BigDecimal> result : results){
               sum = numbereCalculator.sumFactorial(result.get(), sum);
            }
            System.out.println("Euler's number: " + sum.toString());
            System.out.println("Number of threads used: " +  Thread.activeCount());
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
    }
}
