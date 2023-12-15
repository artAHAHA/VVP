package Task10;

public class Circle {
    private double x; // Координата x центра круга
    private double y; // Координата y центра круга
    private double radius; // Радиус круга

    // Конструктор для создания круга
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Геттеры для получения координат и радиуса
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }
}

