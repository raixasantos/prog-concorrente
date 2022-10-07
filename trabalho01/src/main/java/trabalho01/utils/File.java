package trabalho01.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    
    /** 
     * Open a file and write the value received.
     * @param path Where is the file to be written.
     * @param value The value to be written on the file.
     * @throws IOException
     */
    public static void writer(String path, long value) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter buffWrite = new BufferedWriter(fileWriter);
        buffWrite.write(value + "\n");
        buffWrite.close();
    }

    
    /** 
     * Write down on a file the time that scenario executed.
     * @param type Which implementation executed.
     * @param scenario Number represents a scenario of the experiment.
     * @param value Time that scenario executed.
     * @throws IOException
     */
    public static void writeResult(String type, int scenario, long value) throws IOException {
        String path = "/home/raissasantos/experimento-" +
                type + "/cenario" + scenario + "/valores";
        writer(path, value);
    }
}
