package Task5;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int num = scanNumber();
        int dashesCount = (num - 7) / 3 + 1;
        printFigure(dashesCount, num);
    }

    public static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printFigure(int dashesCount, int num) {
        printUpperAndUnderParts(dashesCount);
        printUpperMediumAndUnderMediumParts(dashesCount);
        printUnderAndUpperMediumParts(dashesCount);
        printMediumPart(dashesCount, num);
        printUnderAndUpperMediumParts(dashesCount);
        printUpperMediumAndUnderMediumParts(dashesCount);
        printUpperAndUnderParts(dashesCount);
    }

    public static void printUpperAndUnderParts(int dashesCount) {
        System.out.print(" ");
        for (int i = 0; i < dashesCount; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        for (int i = 0; i < dashesCount; i++) {
            System.out.print("-");
        }
        System.out.print("*");
        System.out.println();
    }

    public static void printUpperMediumAndUnderMediumParts(int dashesCount) {
        for (int k = 0; k < dashesCount; k++) {
            System.out.print(" ");
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < dashesCount; i++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public static void printUnderAndUpperMediumParts(int dashesCount){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print("*");
                for (int k = 0; k < dashesCount; k++) {
                    System.out.print("-");
                }
                System.out.print("*");
            }
            for (int d = 0; d < dashesCount; d++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void printMediumPart(int dashesCount, int num) {

        for (int k = 0; k < dashesCount; k++) {
            for (int i = 0; i < 2; i++) {
                System.out.print("|");
                for (int j = 0; j < num - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}