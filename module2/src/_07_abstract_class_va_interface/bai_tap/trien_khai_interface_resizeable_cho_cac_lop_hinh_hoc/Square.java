package _07_abstract_class_va_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class Square extends Shape  {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    public Square() {
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public String toString() {
        return "Square{" +
                "edge=" + edge +
                '}';
    }

    @Override
    public double getArea() {
        return edge * edge;
    }

    @Override
    public void resize(double percent) {
        setEdge(getEdge() + (percent/100));
    }
}
