package _04_lop_va_doi_tuong_trong_java.bai_tap.phuong_trinh_bac_hai;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public static double getDiscriminant(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        return delta;
    }

    public static double getRoot1(double a, double b, double c) {
        double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        return r1;
    }
    public static double getRoot2(double a, double b, double c) {
        double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        return r2;
    }
    public static double getRoot3(double a, double b) {
        double r3 = -b/ 2 *a;
        return r3;
    }
}
