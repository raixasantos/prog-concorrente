package trabalho01.concurrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import trabalho01.utils.File;

public class App {

    /** 
     * Main method to start the concurrent experiment. 
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int numOfExecutions = 21;
        int[] scenarios = { 5, 10, 30, 50, 100, 150, 300 };
        String type = "concurrent";

        for (int scenario = 0; scenario < scenarios.length; scenario++) {
            for (int execution = 0; execution < numOfExecutions; execution++) {
                List<Concurrent> threads = new ArrayList<>();
                long start = System.currentTimeMillis();
                for (int index = 0; index < scenarios[scenario]; index++) {
                    Concurrent thread = new Concurrent();
                    threads.add(thread);
                    thread.start();
                }
                for (Thread thread : threads) {
                    thread.join();
                }
                long elapsed = System.currentTimeMillis() - start;
                File.writeResult(type, scenarios[scenario], elapsed);
            }
        }
    }
}
