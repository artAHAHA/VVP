package Task10;

import java.util.List;

public class Solution10 {
    public static int maxNestedCount = 0;

    public static Circle findMaxNestedCircles(List<Circle> circles) {
        maxNestedCount = 0;
        Circle maxNestedCircle = null;

        for (int i = 0; i < circles.size(); i++) {
            int nestedCount = 1;

            for (int j = 0; j < circles.size(); j++) {
                if (i != j && isNested(circles.get(i), circles.get(j))) {
                    nestedCount++;
                }
            }

            if (nestedCount > maxNestedCount || (nestedCount == maxNestedCount && circles.get(i).getRadius() > maxNestedCircle.getRadius())) {
                maxNestedCount = nestedCount;
                maxNestedCircle = circles.get(i);
            }
        }

        return maxNestedCircle;
    }
    public static int circleCount () {
        return maxNestedCount-1;
    }

    // Метод для проверки, вложен ли один круг в другой
    private static boolean isNested(Circle outer, Circle inner) {
        double distance = Math.sqrt(Math.pow(inner.getX() - outer.getX(), 2) + Math.pow(inner.getY() - outer.getY(), 2));
        return distance <= outer.getRadius() - inner.getRadius();
    }

}
