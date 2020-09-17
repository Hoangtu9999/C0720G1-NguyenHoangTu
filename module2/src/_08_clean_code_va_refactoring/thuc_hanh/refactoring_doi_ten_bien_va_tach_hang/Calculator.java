package _08_clean_code_va_refactoring.thuc_hanh.refactoring_doi_ten_bien_va_tach_hang;

public class Calculator {
    public static int calculate(int a, int b, char o) {
        switch (o) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0)
                    return a / b;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
