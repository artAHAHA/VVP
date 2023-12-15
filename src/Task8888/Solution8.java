package Task8888;

//public class Solution8 {
//    public static int[][] solution(int[][] arr) {
//        int rows = arr.length;
//        int cols = arr[0].length;
//
//        int[][] result = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = countFriendlyElements(arr, i, j);
//            }
//        }
//
//        return result;
//    }
//
//    public static int countFriendlyElements(int[][] arr, int row, int col) {
//        int value = arr[row][col];
//
//        arr[row][col] = -1;
//
//        int count = 0;
//
//        if (col < arr[0].length - 1 && arr[row][col + 1] == value) {
//            count += 1 + countFriendlyElements(arr, row, col + 1);
//        }
//
//        if (col > 0 && arr[row][col - 1] == value) {
//            count += 1 + countFriendlyElements(arr, row, col - 1);
//        }
//
//        if (row < arr.length - 1 && arr[row + 1][col] == value) {
//            count += 1 + countFriendlyElements(arr, row + 1, col);
//        }
//
//        if (row > 0 && arr[row - 1][col] == value) {
//            count += 1 + countFriendlyElements(arr, row - 1, col);
//        }
//
//        arr[row][col] = value;
//
//        return count;
//    }
//}

public class Solution8 {
    public static int[][] solution(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    int count = countFriendlyElements(arr, visited, i, j, arr[i][j]);
                    updateResults(result, visited, i, j, count);
                }
            }
        }

        return result;
    }

    public static int countFriendlyElements(int[][] arr, boolean[][] visited, int row, int col, int value) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || visited[row][col] || arr[row][col] != value) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + countFriendlyElements(arr, visited, row + 1, col, value)
                + countFriendlyElements(arr, visited, row - 1, col, value)
                + countFriendlyElements(arr, visited, row, col + 1, value)
                + countFriendlyElements(arr, visited, row, col - 1, value);
    }

    public static void updateResults(int[][] result, boolean[][] visited, int row, int col, int count) {
        if (row < 0 || col < 0 || row >= result.length || col >= result[0].length || !visited[row][col]) {
            return;
        }

        result[row][col] = count - 1;
        visited[row][col] = false;

        updateResults(result, visited, row + 1, col, count);
        updateResults(result, visited, row - 1, col, count);
        updateResults(result, visited, row, col + 1, count);
        updateResults(result, visited, row, col - 1, count);
    }
}


