package _06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Shape() {
    }

    public Shape(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getHalfCircumference() {
        return (side1 + side2 + side3) / 2;
    }

    public double getArea() {
        return Math.sqrt(getHalfCircumference() * (getHalfCircumference() - side1) *
                (getHalfCircumference() - side2) * (getHalfCircumference() - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", diện tích là=" + getArea() +
                ", chu vi là=" + getHalfCircumference()
                ;
    }
}
