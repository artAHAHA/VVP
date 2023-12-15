package Task77777;

public class Solution7 {
    public static void solution(int[] array) {
        int maxLength = 0;
        int start = -1;
        int end = -1;
        int count = 0;
        int secondStart = -1;

        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < array.length; j++) {
                currentSum += array[j];
                if (currentSum == 0 && (j - i + 1) >= maxLength) {
                    if (j - i + 1 > maxLength) {
                        count = 1;
                        secondStart = -1;
                    } else {
                        count++;
                        if (count == 2) {
                            secondStart = i;
                        }
                    }

                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        if (start != -1 && end != -1) {
            if (count == 1) {
                System.out.println("Индекс первого элемента: " + start + " Длина подпоследовательности: " + maxLength + "\n");
            }

            // Если есть вторая подпоследовательность, вывести ее индекс
            if (count >= 2) {
                System.out.println("Индекс первого элемента: " + secondStart + " Длина подпоследовательности: " + maxLength + "\n");
            }

        } else {
            System.out.println("Индекс первого элемента: -1 Длина подпоследовательности: 0\n");
        }
    }
}
