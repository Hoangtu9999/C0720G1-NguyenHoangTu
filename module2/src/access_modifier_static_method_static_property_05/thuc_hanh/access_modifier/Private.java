package access_modifier_static_method_static_property_05.thuc_hanh.access_modifier;

public class Private {
    private int data=40;

    private void msg(){System.out.println("Hello java");}

}



 class Simple{

    public static void main(String args[]){

        Private obj =new Private();

       // System.out.println(obj.data);//Compile Time Error

       // obj.msg();//Compile Time Error

    }
}
