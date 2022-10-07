package trabalho01.concurrent;

import java.io.IOException;

import trabalho01.utils.Task;

public class Concurrent extends Thread {

    public Concurrent() {
    }

    /** Statements to be executed when the thread runs */
    @Override
    public void run() {
        Task task = new Task();
        try {
            task.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
