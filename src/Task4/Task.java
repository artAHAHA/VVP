package Task4;

import java.util.Scanner;

public class Task {
    public static double scanR1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите радиус маленькой окружности: ");
        double r1 = scanner.nextDouble();
        return r1;
    }

    public static double scanR2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите радиус большой окружности: ");
        double R2 = scanner.nextDouble();
        return R2;
    }

    public static double calculateSmallCircleS(double r1) {
        double smallCircleS = Math.PI * Math.pow(r1, 2);
        return smallCircleS;
    }

    public static double calculateBigCircleS(double R2) {
        double bigCircleS = Math.PI * Math.pow(R2, 2);
        return bigCircleS;
    }

    public static double calculateSquareS(double R2) {
        double squareS = 4 * R2 * R2;
        return squareS;
    }

    public static double calculatePaintedS(double smallCircleS, double bigCircleS, double squareS) {
        double paintedPieceSquare = (squareS - bigCircleS) / 4;
        double paintedPieceBigCircle = ((bigCircleS - smallCircleS) / 8) * 3;
        double paintedPieceSmallCircle = (smallCircleS) / 2;
        return (paintedPieceSquare + paintedPieceBigCircle + paintedPieceSmallCircle);
    }


    public static void main(String args[]) {
        double r1 = scanR1();
        double R2 = scanR2();
        double smallCircleS = calculateSmallCircleS(r1);
        double bigCircleS = calculateBigCircleS(R2);
        double squareS = calculateSquareS(R2);
        double answer = calculatePaintedS(smallCircleS, bigCircleS, squareS);
        System.out.println(answer);
    }
}
