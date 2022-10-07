package trabalho01.iterative;

import java.io.IOException;

import trabalho01.utils.File;
import trabalho01.utils.Task;

public class App {
    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int numOfExecutions = 21;
        int[] scenarios = { 5, 10, 30, 50, 100, 150, 300 };
        String type = "iterative";

        Task task = new Task();

        for (int scenario = 0; scenario < scenarios.length; scenario++) {
            long start = System.currentTimeMillis();
            for (int execution = 0; execution < numOfExecutions; execution++) {
                for (int index = 0; index < scenarios[scenario]; index++) {
                    task.run();
                }
            }
            long elapsed = System.currentTimeMillis() - start;
            File.writeResult(type, scenarios[scenario], elapsed);
        }
    }
}
