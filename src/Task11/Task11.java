package Task11;

public class Task11 {
    public static void main(String[] args) {
        int userNumber = Solution11.ScanNumber();
        try {
            String result = Solution11.numberToWords(userNumber);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода.");
        }
        Tests11.Tests();
    }

}


