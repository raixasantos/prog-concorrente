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
        if (args.length == 0 || args.length == 1) {
            printAndExit("Arguments: number of numerical terms and number of threads to execute required!");
        }

        for (int i = 0; i < args.length; i++) {
            if (i == 2) {
                printAndExit("Too many arguments!");
            }

            try {
                if (Integer.parseInt(args[i]) <= 0) {
                    printAndExit("Plese, enter a number greater than zero!");
                }
                params[i] = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e) {
                printAndExit("Invalid arguments!");
            }
        }

        return params;
    }

    
    /** 
     * Print error message and exit program.
     * @param message Message to print.
     */
    private static void printAndExit(String message) {
        System.out.println(message);
        System.exit(-1);
    }
}