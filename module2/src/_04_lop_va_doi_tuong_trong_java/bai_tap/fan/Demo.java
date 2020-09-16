package _04_lop_va_doi_tuong_trong_java.bai_tap.fan;

public class Demo {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        int slow = Fan.SLOW;
        int fast = Fan.FAST;
        int medium = Fan.MEDIUM;

        fan1.setSpeed(10);
        fan1.setOn(true);
        fan1.setRadius(10);
        fan1.setColor("yellow");

        fan2.setSpeed(5);
        fan2.setOn(false);
        fan2.setRadius(5);
        fan2.setColor("blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

}
