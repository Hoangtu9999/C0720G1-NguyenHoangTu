package _05_access_modifier_static_method_static_property.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());// private chỉ sử dụng trong class
        System.out.println(circle.getArea());

    }
}
