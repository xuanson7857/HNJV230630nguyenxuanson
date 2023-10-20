package Exam_Advance_1.run;

import Exam_Advance_1.bussinessImp.Catalog;
import Exam_Advance_1.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("Nhập 1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("Nhập 2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("Nhập 3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("Nhập 4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("Nhập 5. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortIncrementPrice();
                    break;
                case 4:
                    searchCatalog();
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Mời bạn nhập lại lựa chọn");
            }

        } while (true);
    }

    private static void addCategory() {
        System.out.println("Nhập số lượng danh mục");
        int number = Integer.parseInt(sc.nextLine());
        do {
            if (number > 0) {
                break;
            } else {
                System.err.println("bạn cần phải nhập số lượng lớn hơn 0");
            }
        } while (true);
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập danh mục thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
        }
        System.out.println("Hoàn thành thêm " + number + " danh mục sản phẩm");
        System.out.println("DANH SÁCH DANH MUC");
        for (Catalog cata : catalogs) {
            cata.displayData();
        }
    }

    private static void addProduct() {
        System.out.print("Nhập vào số lượng sản phẩm muốn thêm: ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Thêm sản phẩm thứ " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData();
            products.add(newProduct);
        }
        System.out.println("DANH SÁCH SẢN PHẨM HIỆN CÓ");
        for (Product product : products) {
            product.displayData();
        }
        System.out.println("----------------------------------------------");
    }

    private static void sortIncrementPrice() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getImportPrice(), o2.getImportPrice());
            }
        };
        products.sort(comparator);
        System.out.println("Sắp xếp theo giá cả ");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void searchCatalog() {
        System.out.print("Nhập vào tên danh mục sản phẩm: ");
        String catalogName = sc.nextLine();
        for (Product product : products) {
            if (product.getCatalog().getCatalogName().trim().equalsIgnoreCase(catalogName)) {

                product.displayData();
            }
        }

    }
}
