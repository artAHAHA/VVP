/*
package Task10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class Task10{
    public static void main(String[] args) {
        // Пример использования
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(3, 3, 2));
        circles.add(new Circle(3, 3, 1));
        circles.add(new Circle(3, 3, 0.5));

        int maxNestedCirclesCount = findMaxNestedCircles(circles);
        System.out.println("Максимальное количество вложенных кругов: " + maxNestedCirclesCount);
    }

    // Метод для поиска максимального количества вложенных кругов
    public static int findMaxNestedCircles(List<Circle> circles) {
        // Сортируем круги по убыванию радиуса
        Collections.sort(circles, Comparator.comparingDouble(Circle::getRadius).reversed());

        int maxNestedCount = 0;

        for (int i = 0; i < circles.size(); i++) {
            int nestedCount = 1; // Текущий круг в счете

            for (int j = i + 1; j < circles.size(); j++) {
                // Проверяем, вложен ли текущий круг в другой
                if (isNested(circles.get(i), circles.get(j))) {
                    nestedCount++;
                }
            }

            // Обновляем максимальное количество вложенных кругов
            maxNestedCount = Math.max(maxNestedCount, nestedCount);
        }

        return maxNestedCount;
    }

    // Метод для проверки, вложен ли один круг в другой
    private static boolean isNested(Circle outer, Circle inner) {
        double distance = Math.sqrt(Math.pow(inner.getX() - outer.getX(), 2) + Math.pow(inner.getY() - outer.getY(), 2));
        return distance + inner.getRadius() <= outer.getRadius();
    }
}
*/

package Task10;
/*

import java.util.ArrayList;
import java.util.List;

public class Task10 {
    public static void main(String[] args) {
        // Пример использования
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(3, 3, 3));
        circles.add(new Circle(3, 3, 3));
        circles.add(new Circle(3, 3, 213));

        int maxNestedCirclesCount = findMaxNestedCircles(circles);
        System.out.println("Максимальное количество вложенных кругов: " + maxNestedCirclesCount);
    }

    // Метод для поиска максимального количества вложенных кругов
    public static int findMaxNestedCircles(List<Circle> circles) {
        int maxNestedCount = 0;

        for (int i = 0; i < circles.size(); i++) {
            int nestedCount = 1; // Текущий круг в счете

            for (int j = i + 1; j < circles.size(); j++) {
                // Проверяем, вложен ли текущий круг в другой
                if (isNested(circles.get(i), circles.get(j))) {
                    nestedCount++;
                }
            }

            // Обновляем максимальное количество вложенных кругов
            maxNestedCount = Math.max(maxNestedCount, nestedCount);
        }

        return maxNestedCount;
    }

    // Метод для проверки, вложен ли один круг в другой
    private static boolean isNested(Circle outer, Circle inner) {
        double distance = Math.sqrt(Math.pow(inner.getX() - outer.getX(), 2) + Math.pow(inner.getY() - outer.getY(), 2));
        return distance + inner.getRadius() <= outer.getRadius();
    }
}*/


import java.util.List;

public class Task10 {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMainTask10().setVisible(true);
            }
        });
    }

}
