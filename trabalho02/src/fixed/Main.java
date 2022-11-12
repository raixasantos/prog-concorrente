package trabalho02.src.fixed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import trabalho02.src.handleinput.HandleInput;
import trabalho02.src.numberecalculator.*;

public final class Main {

    /**
     * Calculate the Euler's number with Fixed Thread Pool.
     * @param args The arguments of the program.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] input = HandleInput.handleArgsInput(args);
        int num_terms = input[0], num_threads = input[1];
        
        ExecutorService executor =
            Executors.newFixedThreadPool(num_threads);

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
            System.out.println("Number of threads used: " + num_threads);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
    }
}