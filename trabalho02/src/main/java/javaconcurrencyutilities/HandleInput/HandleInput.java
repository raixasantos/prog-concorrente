package javaconcurrencyutilities.HandleInput;

import java.util.ArrayList;
import java.util.List;

public class HandleInput {
    public static List<Integer> handleArgsInput(String[] args) {
        List<Integer> params = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        return params;
    }
}
