package Task10;

import Task10.ArrayUtils;
import Task10.FrameMainTask10;
import Task10.SwingUtils;
import Task10.Task10;
import org.apache.commons.cli.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Демонстрируется работа с библиотекой apache commons-cli
 *
 * @see <a href="https://urvanov.ru/2019/06/08/apache-commons-cli/">Apache Commons CLI</a>
 * @see <a href="https://coderlessons.com/tutorials/java-tekhnologii/izuchite-apache-commons-cli/apache-commons-cli-kratkoe-rukovodstvo">Apache Commons CLI — Краткое руководство</a>
 */
public class Task10CMD {
    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -f |  -i <in-file> [-o <out-file>])";

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMainTask10().setVisible(true);
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
            int[][] matrix = ArrayUtils.readIntArray2FromFile(inputFilename);
            if (matrix == null) {
                System.err.printf("Can't read array from \"%s\"%n", inputFilename);
                System.exit(2);
            }
            int[] result = null;
            if (cmdLine.hasOption("f")) {
                List<Circle> circles = new ArrayList<>();
                for (int i = 0; i < matrix.length; i++) {
                    double x = matrix[i][0];
                    double y = matrix[i][1];
                    double radius = matrix[i][2];

                    circles.add(new Circle(x, y, radius));
                }
                Circle maxNestedCircle = Solution10.findMaxNestedCircles(circles);

                if (maxNestedCircle != null) {
                    int maxNestedCount = Solution10.circleCount();
                    result = new int[]{(int) maxNestedCircle.getX(), (int) maxNestedCircle.getY(), (int) maxNestedCircle.getRadius(), maxNestedCount};
                }
            }


            PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
            out.println(ArrayUtils.toString(result));
            out.close();
        }
    }
}
