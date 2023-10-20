package Exam_Advance_1.bussinessImp;

import Exam_Advance_1.bussiness.IShop;
import Exam_Advance_1.run.ProductManagement;

import java.util.Scanner;


import static Exam_Advance_1.run.ProductManagement.*;


public class Product implements IShop {
    int productId;
    String productName;
    String title;
    String descriptions;
    Catalog catalog;
    float importPrice;
    float exportPrice;
    boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        // Nhập sản phảm từ từ bàn phim
        System.out.println("Mời bạn nhập mã sản phẩm");
        this.productId = Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập tên sản phẩm");
       this.productName = sc.nextLine();
        System.out.println("Mời bạn nhập tiêu đề sản phẩm");
        this.title = sc.nextLine();
        System.out.println("Mời bạn nhập mô tả sản phẩm");
        this.descriptions = sc.nextLine();
        System.out.println("Mời bạn nhập danh mục sản phẩm");
        if (catalogs.isEmpty()) {
            System.out.println("Danh sách mã danh mục hiện trống. Vui lòng tạo mới mã danh mục trước khi tiếp tục");
            System.out.println("Tạo danh mục Catalog");
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
            this.catalog = newCatalog;
        } else {
            System.out.println("************************DANH SÁCH MÃ DANH MỤC HIỆN CÓ************************");
            for (Catalog catalog1 : catalogs) {
                catalog1.displayData();
            }
            System.out.println("Nhập vào mã danh mục");
            int catalogId = Integer.parseInt(sc.nextLine());
            Catalog result = new Catalog();
            boolean categoryExist = false;
            for (Catalog catalog2 : catalogs) {
                if (catalog2.getCatalogId() == catalogId) {
                    categoryExist = true;
                    result = catalog2;
                    break;
                }
            }
            if (categoryExist) {
                this.catalog = result;
            } else {
                System.out.println("Mã danh mục bạn vừa nhập không tồn tại");
                boolean isCatalogCreated = true;
                do {
                    System.out.println("Bạn có muốn tạo mã danh mục mới không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            Catalog newCatalog = new Catalog();
                            newCatalog.inputData();
                            catalogs.add(newCatalog);
                            this.catalog = newCatalog;
                            isCatalogCreated = false;
                            break;
                        case 2:
                            System.out.println("Mã danh mục không thể để trống");
                            break;
                        default:
                            System.err.println("Bạn chỉ có thể lựa chọn 1 hoặc 2");
                    }
                } while (isCatalogCreated);
            }
        }

        System.out.println("Mời bạn nhập giá nhập sản phẩm");
        this.importPrice= Float.parseFloat(sc.nextLine());
        this.exportPrice = importPrice * RATE;
        System.out.println("Mời bạn nhập trạng thái [true/false]");
      this.productStatus = Boolean.parseBoolean(sc.nextLine());

    }
    @Override
    public void displayData () {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Tên danh mục sản phẩm: %s\n", this.productId, this.productName, this.catalog.getCatalogName());
        System.out.printf("Giá bán sản phẩm: %.2f - Trạng thái sản phẩm: %b\n", this.exportPrice, this.productStatus);
    }


}
