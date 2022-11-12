package trabalho02.src.handleinput;
    
import java.util.ArrayList;
import java.util.List;

public class HandleInput {
    public static int[] handleArgsInput(String[] args) {
        int[] params = new int[] { 0, 0 };
        if (args.length == 0) {
            return new int[] {100, 50};
        }

        for (int i = 0; i < args.length; i++) {
            if (i == 1) break;
            try {
                params[i] = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e) {
                params[i] = 0;
            }
        }

        return params;
    }
}