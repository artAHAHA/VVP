package Task11;

import java.util.Scanner;

public class Solution11 {
    public static String numberToWords(int number) {
        if (number == 0) {
            return "Ноль";
        }


        StringBuilder result = new StringBuilder();

        int thousands = (number / 1000) % 1000;
        if (thousands > 0) {
            if (thousands % 10 == 0) {
                result.append(convertBelowThousand(thousands, "")).append("Тысяч ");
/*            } else if (thousands == 1) {
                result.append("Одна Тысяча ");
            } else if (thousands == 2) {
                result.append("Две тысячи ");*/
            }

            else if (thousands % 10 == 1 && thousands % 100 != 11) {
                result.append(convertBelowThousand(thousands, "").replace("Один", "Одна Тысяча ").strip()).append(" ");
            } else if (thousands % 10 == 2 && thousands % 100 != 12) {
                result.append(convertBelowThousand(thousands, "").replace("Два", "Две Тысячи ").strip()).append(" ");
            } else if (thousands % 10 == 3 && thousands % 100 != 13) {
                result.append(convertBelowThousand(thousands, "")).append(" Тысячи ");
            } else if ((thousands % 10 == 3 || thousands % 10 == 4) && thousands % 100 != 14 && thousands != 13) {
                result.append(convertBelowThousand(thousands, "")).append(" Тысячи ");
            } else {
                result.append(convertBelowThousand(thousands, " Тысяч "));
            }
        }
        int remainder = number % 1000;
        result.append(convertBelowThousand(remainder, ""));
        return result.toString().strip();
    }

    public static String convertBelowThousand(int num, String form) {
        String[] units = {"", "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять"};
        String[] teens = {"", "Одиннадцать", "Двенадцать", "Тринадцать", "Четырнадцать", "Пятнадцать", "Шестнадцать", "Семнадцать",
                "Восемнадцать", "Девятнадцать"};
        String[] tens = {"", "Десять", "Двадцать", "Тридцать", "Сорок", "Пятьдесят", "Шестьдесят", "Семьдесят", "Восемьдесят",
                "Девяносто"};
        String[] hundreds = {"", "Сто", "Двести", "Триста", "Четыреста", "Пятьсот", "Шестьсот", "Семьсот", "Восемьсот", "Девятьсот"};
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return units[num] + form;
        } else if (num < 20) {
            return teens[num - 10] + form;
        } else if (num < 100) {
            return tens[num / 10] + " " + convertBelowThousand(num % 10, form);
        } else {
            return hundreds[num / 100] + " " + convertBelowThousand(num % 100, form);
        }
    }

    public static int ScanNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число (от 0 до 1000000): ");
        int userInput = scanner.nextInt();
        if (userInput > 1000000) {
            System.out.println("Перечитай условие и попробуй ещё раз:)");
        }
        return userInput;
    }
}
