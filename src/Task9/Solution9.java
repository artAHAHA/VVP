package Task9;

import java.util.*;

public class Solution9 {    public static List<Integer> createNewList(List<Integer> list) {
    sort(list);
    int count = 0;
    int maxLength = 0;
    int startIndex = 0;
    int currentIndex = 0;

    for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i + 1) - list.get(i) == 1) {
            count++;
            if (count > maxLength) {
                maxLength = count;
                currentIndex = i + 1;
                startIndex = currentIndex - maxLength;
            } else if (count == maxLength && list.get(startIndex) > list.get(currentIndex - maxLength + 1)) {
                startIndex = currentIndex - maxLength + 1;
            }
        } else {
            count = 0;
        }
    }

    List<Integer> result = list.subList(startIndex, currentIndex + 1);
    return new ArrayList<>(result);
}

    public static void sort(List<Integer> list) {
        int[] arr = new int[list.size()];
        Set<Integer> set = new HashSet<>();
        for (Integer integer : list) {
            if (!set.contains(integer)) {
                arr[set.size()] = integer;
                set.add(integer);
            }
        }
        quickSort(arr,0, arr.length-1);
        ListIterator<Integer> i = list.listIterator();
        for (int value : arr) {
            i.next();
            i.set(value);
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];


        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }


        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
