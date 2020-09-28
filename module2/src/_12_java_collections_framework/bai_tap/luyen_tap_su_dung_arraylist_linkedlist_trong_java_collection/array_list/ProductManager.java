package _12_java_collections_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection.array_list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> listProduct = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Nhập id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.print("Nhập giá:");
        int price = scanner.nextInt();
        Product product1 = new Product(id, name, price);
        listProduct.add(product1);
    }

    public static void showProduct() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }

    public static void editProductById() {
        System.out.println("Nhập id sản phẩm bạn muốn sửa:");
        int idProduct = scanner.nextInt();
        for (int i = 0; i < listProduct.size(); i++) {
            if (idProduct == listProduct.get(i).getId()) {
                System.out.println(listProduct.get(i));
                scanner.nextLine();
                System.out.println("Nhập tên muốn sửa:");
                String name = scanner.nextLine();
                listProduct.get(i).setName(name);
                System.out.println(listProduct.get(i));
            }
        }
    }

    public static void removeProductById() {
        System.out.println("Nhập id sản phẩm bạn muốn xóa:");
        int idProduct = scanner.nextInt();
        for (int i = 0; i < listProduct.size(); i++) {
            if (idProduct == listProduct.get(i).getId()) {
                listProduct.remove(i);
            }
        }
    }

    public static void searchProducById() {
        System.out.println("Nhập tên muốn tìm kiếm:");
        scanner.nextLine();
        String nameSearch = scanner.nextLine();
        for (int i = 0; i < listProduct.size(); i++) {
            if (nameSearch.equals(listProduct.get(i).getName())) {
                System.out.println(listProduct.get(i));
            }
        }
    }

    public static void sortUpAscending() {
        Collections.sort(listProduct, new SortUpAscending());
        showProduct();
    }

    public static void descendingArrangement() {
        Collections.sort(listProduct, new DescendingArrangement());
        showProduct();
    }

    public static void menu() {
        System.out.println("-----------------------\n" +
                "1.Thêm sản phẩm\n" +
                "2.Sửa thông tin sản phẩm theo id\n" +
                "3.Xoá sản phẩm theo id\n" +
                "4.Hiển thị danh sách sản phẩm\n" +
                "5.Tìm kiếm sản phẩm theo tên\n" +
                "6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n"
                + "------------------------------"
        );
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                addProduct();
                menu();
                break;
            case 2:
                editProductById();
                menu();
                break;
            case 3:
                removeProductById();
                menu();
                break;
            case 4:
                showProduct();
                menu();
                break;
            case 5:
                searchProducById();
                menu();
                break;
            case 6:
                System.out.println("1.Tăng dần     2. Giảm dần");
                int inputSort = scanner.nextInt();
                switch (inputSort) {
                    case 1:
                        sortUpAscending();
                        menu();
                        break;
                    case 2:
                        descendingArrangement();
                        menu();
                        break;
                }
                break;
            default:
                System.out.println("Nhập từ 1 - 7");
                break;
        }
    }
}
