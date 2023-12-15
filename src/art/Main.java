package art;


public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,213,321,1,23,312,321,321,1,1,321};
        int count = 1;
        int maxCount = 0;
        int element = 0;
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                count = 1;
                element = a[i];

            } else if (count == maxCount && a[i] > element) {
                count = 1;
                element = a[i];
            } else {
                count = 1;
            }

        }
        count = maxCount;
        if (count >= 2) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == element) {
                    count--;
                }
                if (count == 1) {
                    index = i;
                    break;
                }
            }
        }


        System.out.println("Count: " + maxCount);
        System.out.println("Element: " + element);
        System.out.println("Index: " + index);
    }
}