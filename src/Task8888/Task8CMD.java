package Task8888;
import org.apache.commons.cli.*;


import java.io.PrintStream;
import java.util.Locale;


/**
 * Демонстрируется работа с библиотекой apache commons-cli
 *
 * @see <a href="https://urvanov.ru/2019/06/08/apache-commons-cli/">Apache Commons CLI</a>
 * @see <a href="https://coderlessons.com/tutorials/java-tekhnologii/izuchite-apache-commons-cli/apache-commons-cli-kratkoe-rukovodstvo">Apache Commons CLI — Краткое руководство</a>
 */
public class Task8CMD {
    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -f |  -i <in-file> [-o <out-file>])";

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("f", "find-friendly-elements", false, "Friendly Elements");
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("o", "output-file", true, "Output file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (cmdLine.hasOption("h")) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }
        if (cmdLine.hasOption("w")) {
            winMain();
        } else {
            if (!cmdLine.hasOption("i") ||
                    !cmdLine.hasOption("f")) {
                new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
                System.exit(1);
            }
            String inputFilename = cmdLine.getOptionValue("i");
            int[][] arr2 = ArrayUtils.readIntArray2FromFile(inputFilename);
            if (arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", inputFilename);
                System.exit(2);
            }
            if (cmdLine.hasOption("f")) {
                arr2 = Solution8.solution(arr2);
            }


            PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
            out.println(ArrayUtils.toString(arr2));
            out.close();
        }
    }
}
