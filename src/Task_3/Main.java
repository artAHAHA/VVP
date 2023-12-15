package Task_3;
//73

import java.util.Scanner;

public class Main {
    public static double scanXCoordinate() {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        return x;
    }

    public static double scanYCoordinates() {
        Scanner scanner = new Scanner(System.in);
        double y = scanner.nextDouble();
        return y;
    }

    // Соответствуют первому варианту задачи
    public static final Line L1 = new Line(3, 1, -4);
    public static final HorizontalParabola P1 =
            new HorizontalParabola(3, 6, 0.5);
    public static final Circle C1 = new Circle(1, 8, 2);

    public static final VerticalParabola P2 = new VerticalParabola(0.25, 0, 1);

    public static SimpleColor getColor(double x, double y) {
        if (L1.isPointAboveLine(x, y) && C1.isPointInCircle(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (!L1.isPointAboveLine(x, y) && C1.isPointInCircle(x, y)) {
            return SimpleColor.GRAY;
        }
        if (!L1.isPointAboveLine(x, y)) {
            return SimpleColor.BLUE;
        }
        if (P2.isPointInsideParabola(x, y) && P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.GREEN;
        }
        if (P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (L1.isPointAboveLine(x, y) && P2.isPointInsideParabola(x, y) && !C1.isPointInCircle(x, y) && !P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.YELLOW;
        }


        return SimpleColor.WHITE;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.println(getColor(x, y));
    }


    public static void main(String args[]) {
        double xCoordinate = scanXCoordinate();
        double yCoordinate = scanYCoordinates();
        printColorForPoint(xCoordinate, yCoordinate);
    }
}


