package _06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Triangle extends Shape{
    private String color ;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3, String color) {
        super(side1, side2, side3);
        this.color = color;
    }

    @Override
    public String toString() {
        return  super.toString() + ' ' +
                "color='" + color ;
    }
}
