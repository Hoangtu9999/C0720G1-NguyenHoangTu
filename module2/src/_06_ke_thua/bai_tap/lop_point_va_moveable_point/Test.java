package _06_ke_thua.bai_tap.lop_point_va_moveable_point;

import _06_ke_thua.bai_tap.lop_point2D_va_lop_point3D.Point2D;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2f,3f);
        System.out.println(point2D);

        MoveablePoint moveablePoint = new MoveablePoint(4.5f,3.6f,8.6f,5.4f);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
