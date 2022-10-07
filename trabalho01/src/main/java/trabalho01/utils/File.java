package trabalho01.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void writer(String path, long value) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append(value + "\n");
        buffWrite.close();
    }

    public static void writeResult(String type, int scenario, long value) throws IOException {
        String path = "/home/raissasantos/experimento-" +
                type + "/cenario" + scenario + "/valores";
        writer(path, value);
    }
}
