public class Circle {
    float radius;

    Circle(float radius) {
        this.radius = radius;
    }

    public double SquareCircle() {
        return Math.PI * Math.pow(radius, 2);
    }
}
