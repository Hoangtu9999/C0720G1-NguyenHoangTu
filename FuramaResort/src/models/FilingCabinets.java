package models;

import commons.FileUtils;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FilingCabinets {
    public static final String FILE_NAME_EMPLOYEE = "src/data/Employee.csv";
    private static Stack<Employee> listStack = new Stack<>();

    public static void readFileEmpoyee() {
        List<String> listEmployee = FileUtils.readFile(FILE_NAME_EMPLOYEE);
        for (String list : listEmployee) {
            String[] split = list.split(",");
            if (split.length != 1) {
                Employee employee1 = new Employee(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4])
                        , split[5], split[6], split[7], Integer.parseInt(split[8]));
                listStack.add(employee1);
            }
        }
    }

    public static void employeeProfileSearch() {
        Scanner scanner = new Scanner(System.in);
        readFileEmpoyee();
        int size = listStack.size();
        boolean flag = false;
        System.out.print("Nhập tên bạn muốn tìm hoặc id:");
        String input = scanner.nextLine();
        for (int i = 0; i < size; i++) {
            if (listStack.peek().getIdEmployee().equals(input)) { //001
                System.out.println(listStack.pop());
                flag = true;
                continue;
            }
            listStack.pop();
        }
        if (!flag) {
            System.err.println("Không có nhân viên bạn muốn tìm");
        }

    }
}
