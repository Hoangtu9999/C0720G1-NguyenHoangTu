package _18_string_va_regex.bai_tap.validate_so_dien_thoai;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static boolean checkInputName(String phone) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$"; //"84-0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone;
        do {
            System.out.println("Mời bạn nhập số điện thoại:");
            phone = scanner.nextLine();

        } while (!checkInputName(phone));

        if (checkInputName(phone) == true){
            System.out.println("bạn đã nhập đúng");
        }

    }
}
