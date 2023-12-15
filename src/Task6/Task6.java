package Task6;

import java.util.Scanner;

public class Task6 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите x: ");
            double x = scanner.nextDouble();

            System.out.print("Введите n: ");
            int n = scanner.nextInt();

            double e = Math.E;

            function(x,n,e);

        }

        public static void function(double x, double n, double e){
            double sum1 = 0; //сумма n членов посл
            double sum2 = 0; //сумма слагаемых больших е
            double sum3 = 0; //сумма слагаемых болших e/10

            double numberInTheRow = 1; //n-ый член ряда

            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    sum1 += numberInTheRow;
                } else {
                    numberInTheRow *= (-x / (i-1));
                    sum1 += numberInTheRow;

                    if (Math.abs(numberInTheRow) > e) {
                        sum2 += numberInTheRow;
                    }

                    if (Math.abs(numberInTheRow) > e / 10) {
                        sum3 += numberInTheRow;
                    }
                }
            }

            double functionValue = Math.exp(-x);

            System.out.println("Сумма n слагаемых: " + sum1);
            System.out.println("Сумма слагаемых, по модулю больших e: " + sum2);
            System.out.println("Сумма слагаемых, по модулю больших e/10: " + sum3);
            System.out.println("Значение функции с помощью Math.exp: " + functionValue);
        }
}

