package _17_IO_binary_file_va_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static final String PATH_FILE = "src/_17_IO_binary_file_va_serialization/bai_tap/quan_ly_san_pham_luu_ra_file_nhi_phan/A.csv";
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> listProduct = new ArrayList<>();

    public static void outputStream(String pathFile, List<Product> products) {
        try {
            OutputStream outputStream = new FileOutputStream(pathFile);
            ObjectOutputStream bo = new ObjectOutputStream(outputStream);

            bo.writeObject(products);

            bo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputString(String pathFile) {
        try {
            InputStream inputStream = new FileInputStream(pathFile);
            ObjectInputStream bi = new ObjectInputStream(inputStream);

            List<Product> productList = (List<Product>) bi.readObject();
            for (Product product :productList){
                System.out.println(product);
            }
            bi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct() {
        System.out.println("Nhập đi bạn ơi");
        System.out.print("Nhập id đi ba:");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sp đi má:");
        String nameProduct = scanner.nextLine();
        System.out.print("Nhập hãng sx dùm trời ơi:");
        String productionDelay = scanner.nextLine();
        System.out.print("Nhập giá đi bạn ơi:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mô tả đi em ơi:");
        String otherDescriptions = scanner.nextLine();

        Product product = new Product(id, nameProduct, productionDelay, price, otherDescriptions);
        listProduct.add(product);
        outputStream(PATH_FILE, listProduct);
    }

    public static void displayproduct() {
        inputString(PATH_FILE);
    }
    public static void searchProduct(){
        System.out.print("Nhập tên cần tìm:");
        String nameSearch = scanner.nextLine();

        for (Product product : listProduct){
            if (nameSearch.equals(product.getName())){
                System.out.println(product);
            }else {
                System.out.println("Không có !");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("-------------------\n"
                + "1. Thêm \n"
                + "2. Hiển thị \n"
                + "3. Tìm kiếm \n"
                + "---------------------");
        System.out.print("Nhập chọn:");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        switch (inputNumber) {
            case 1:
                addProduct();
                displayMenu();
                break;
            case 2:
                displayproduct();
                displayMenu();
                break;
            case 3:
                searchProduct();
                displayMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng chọn từ 1 - 4");
                break;
        }

    }

    public static void main(String[] args) {
        displayMenu();


    }
}
