package Task2;

import java.util.Scanner;

public class Task_2 {
    public static double scanRadius() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите радиус окружности: ");
        double r = scanner.nextDouble();
        return r;
    }

    public static double scanSquareSide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону квадрата ");
        double a = scanner.nextDouble();
        return a;
    }
    public static void printAnswer(String answer){
        System.out.println(answer);
    }
    public static String sizeCheck(double r, double a) {
        if (r * r >= a * a / 2)
            return "Квадрат можно закрасить 1 кругом";
        else if (r * r >= a * a * 5 / 16)
            return "Квадрат можно закрасить 2 кругами";
        else if (r * r >= a * a * 72 / 256)
            return "Квадрат можно закрасить 3 кругами";
        else if (r * r >= a * a / 8)
            return "Квадрат можно закрасить 4 кругами";
        else
            return "Квадрат можно закрасить нельзя";
        
    }

    public static void main(String args[]) {
        double circleRadius = scanRadius();
        double squareSide = scanSquareSide();
        String answer = sizeCheck(circleRadius, squareSide);
        printAnswer(answer);

    }
}
