package _07_abstract_class_va_interface.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[1];
        shapes[0] = new Square(5);

        for (Shape shape : shapes){
            if(shape instanceof Square){
                System.out.println(shape.getArea());
                shape.howToColor();
            }
        }
    }
}
