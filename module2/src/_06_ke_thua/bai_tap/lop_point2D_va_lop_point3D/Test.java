package _06_ke_thua.bai_tap.lop_point2D_va_lop_point3D;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.4f,2.3f);
        System.out.println(point2D);

        Point3D point3D = new Point3D(3.5f,4.6f,6.7f);
        System.out.println(point3D);
        for (int i = 0 ; i <point3D.getXYZ().length ; i++ ){
            System.out.println(point3D.getXYZ()[i]);
        }
    }
}
