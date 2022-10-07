package trabalho01.sequential;

import java.io.IOException;

import trabalho01.utils.File;
import trabalho01.utils.Task;

public class App {

    /**
     * Main method to start the sequential experiment. 
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int numOfExecutions = 21;
        int[] scenarios = { 5, 10, 30, 50, 100, 150, 300 };
        String type = "sequential";

        Task task = new Task();

        for (int scenario = 0; scenario < scenarios.length; scenario++) {
            for (int execution = 0; execution < numOfExecutions; execution++) {
                long start = System.currentTimeMillis();
                for (int index = 0; index < scenarios[scenario]; index++) {
                    task.run();
                }
                long elapsed = System.currentTimeMillis() - start;
                File.writeResult(type, scenarios[scenario], elapsed);
            }
        }
    }
}
