package Task9;

import org.apache.commons.cli.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;

public class Task9CMD {


    /**
     * Демонстрируется работа с библиотекой apache commons-cli
     *
     * @see <a href="https://urvanov.ru/2019/06/08/apache-commons-cli/">Apache Commons CLI</a>
     * @see <a href="https://coderlessons.com/tutorials/java-tekhnologii/izuchite-apache-commons-cli/apache-commons-cli-kratkoe-rukovodstvo">Apache Commons CLI — Краткое руководство</a>
     */
    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -f |  -i <in-file> [-o <out-file>])";

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMainTask9().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("f", "DO IT", false, "Friendly Elements");
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
            int[] arr = ArrayUtils.readIntArrayFromFile(inputFilename);
            if (arr == null) {
                System.err.printf("Can't read array from \"%s\"%n", inputFilename);
                System.exit(2);
            }
            int[] resultArray = null;
            if (cmdLine.hasOption("f")) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int value : arr) {
                    list.add(value);
                }
                Solution9.sort(list);
                ArrayList<Integer> resultList = new ArrayList<>(Solution9.createNewList(list));
                resultArray = new int[resultList.size()];
                for (int i = 0; i < resultList.size(); i++) {
                    resultArray[i] = resultList.get(i);
                }

            }


            PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
            out.println(ArrayUtils.toString(resultArray));
            out.close();
        }
    }
}

