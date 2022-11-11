package javaconcurrencyutilities.Fixed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javaconcurrencyutilities.NumbereCalculator.NumbereCalculator;

/**
 * Hello world!
 */
public final class App {

    private static final int NUM_THREADS = 50;

	/** Number of tasks to execute */
	private static final int NUM_TASKS = 100;

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor =
        Executors.newFixedThreadPool(NUM_THREADS);

        List<Future<BigDecimal>> results = new ArrayList<>();
    
        for (int i = 0; i < NUM_TASKS; i++) {
            Callable<BigDecimal> task = new NumbereCalculator(new BigDecimal(i));
            Future<BigDecimal> factorial = executor.submit(task);
            results.add(factorial);
        }
        
        
        try {
            BigDecimal sum = new BigDecimal(0);
            for(Future<BigDecimal> result : results){
                sum.add(result.get());
            }
            System.out.print("Euler's number: " + sum);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
    }
}


