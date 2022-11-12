package trabalho02.src.handleinput;
    
import java.util.ArrayList;
import java.util.List;

public class HandleInput {
    
    /** 
     * Handle command line to get number of numerical terms and number of threads to execute.
     * @param args The arguments of the program.
     * @return int[] Number of numerical terms and number of threads to execute.
     */
    public static int[] handleArgsInput(String[] args) {
        int[] params = new int[] { 0, 0 };
        if (args.length == 0) {
            return new int[] {100, 50};
        }

        for (int i = 0; i < args.length; i++) {
            if (i == 2) break;
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