package lop_va_doi_tuong_trong_java_04.bai_tap.fan;

public class Demo {
    public static void main(String[] args) {
        Fan fan1 = new Fan(10,true,10,"yellow ");
        Fan fan2 = new Fan(5,false,5,"blue  ");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

}
