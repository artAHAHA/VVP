/*
package Task77777;

import java.util.HashMap;
import java.util.Map;

public class Task71 {
    public static void main(String[] args) {
        Tests.main(args);

        int[] arr = ArrayUtils.readIntArrayFromConsole();
        int[] result = solution(arr);

        if (result[0] == -1) {
            System.out.println("Позиция первого элемента подпоследовательности: -1");
        } else {
            System.out.println("Позиция первого элемента подпоследовательности: " + result[0] +
                    " Количество элементов: " + result[1]);
        }
    }


    public static int[] solution(int[] numbers) {
        int maxLength = 0, maxStartIndex = -1, currentSum = 0;
        int count = 0;

        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        for (int index = 0; index < numbers.length; index++) {
            currentSum += numbers[index];

            if (currentSum == 0) {
                maxLength = index + 1;
                maxStartIndex = 0;
                count = 1;
            }

            if (sumIndexMap.containsKey(currentSum)) {
                int startIndex = sumIndexMap.get(currentSum) + 1;
                int currentLength = index - startIndex + 1;

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStartIndex = startIndex;
                    count = 1;
                } else if (currentLength == maxLength) {
                    count++;
                    if (count == 2) {
                        maxStartIndex = startIndex;
                    }
                }
            } else {
                sumIndexMap.put(currentSum, index);
            }
        }

        if (maxLength == 0) {
            return new int[]{-1, 0};
        }

        int[] result = {maxStartIndex, maxLength};
        return result;
    }
}


*/
package Task77777;


public class Task71 {
    public static void main(String[] args) {
        Tests.main(args);
        int[] arr = ArrayUtils.readIntArrayFromConsole();
        Solution7.solution(arr);
    }
}


