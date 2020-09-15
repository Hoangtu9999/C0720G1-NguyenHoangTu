package access_modifier_static_method_static_property_05.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {

        return Math.PI * radius *radius;
    }
}
