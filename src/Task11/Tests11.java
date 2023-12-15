package Task11;

import java.util.Random;

public class Tests11 {
    public static void Tests() {
        for (int i = 0; i <= 20; i++) {
            Random rand = new Random();
            int num = rand.nextInt(1000000);
            System.out.println(num + " " + Solution11.numberToWords(num));
        }
    }
}
