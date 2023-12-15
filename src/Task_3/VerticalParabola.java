package Task_3;

public class VerticalParabola {
    public double a;
    public double b;
    public double c;

    public VerticalParabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointInsideParabola(double x, double y) {

        return y >= a * Math.pow(x, 2) + b * x + c;
    }

}

