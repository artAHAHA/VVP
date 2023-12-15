package Task77777;

import java.util.Arrays;

public class Tests {
    public static void main(String args[]) {
        test(new int[]{-4, 4, 1, 2, -2, 5, 7, -1, -1, -1, -1, -1, -1, -1, -1});
        test(new int[]{2, -1, 3, -2, 4, 1, -5, 4});
        test(new int[]{4, -6, 3, -1, 12, 0, 0, 0, 0});
        test(new int[]{});
        test(new int[]{5});
        test(new int[]{3, -3});
        test(new int[]{1, 2, 3});
        test(new int[]{1, -1, 2});
        test(new int[]{1000000, -1000000, 2000000, -2000000, 3000000});
        test(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, -3, -3, 3, 3});

    }

    public static void test(int[] numbers) {
        System.out.println("Входной массив: " + Arrays.toString(numbers));
        Solution7.solution(numbers);
    }
}
