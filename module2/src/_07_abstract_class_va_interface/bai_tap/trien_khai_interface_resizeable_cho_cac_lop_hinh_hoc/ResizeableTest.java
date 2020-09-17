package _07_abstract_class_va_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(7,9);
        shapes[2] = new Square(9);

        for (Shape shape : shapes){
            System.out.println(shape);

            if(shape instanceof Circle){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }
            if (shape instanceof Resizeable){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }
            if(shape instanceof Square){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }

            double random = Math.random();
            shape.resize(random);


            if(shape instanceof Circle){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }
            if (shape instanceof Resizeable){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }
            if(shape instanceof Square){
                System.out.println("Area");
                System.out.println(shape.getArea());
            }

        }
    }
}
