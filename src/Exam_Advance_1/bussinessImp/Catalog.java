package Exam_Advance_1.bussinessImp;

import Exam_Advance_1.bussiness.IShop;

import java.util.Scanner;



public class Catalog implements IShop {
    int catalogId;
    String catalogName;
    int priority;
    String descriptions;
    boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập mã danh sách sản phẩm");
        this.catalogId= Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập tên danh mục sản phẩm");
        this.catalogName = sc.nextLine();
        System.out.println("Mời bạn nhập độ ưu tiên");
        this.priority = Integer.parseInt(sc.nextLine());

        System.out.println("Mời bạn nhập mô tả danh mục sản phẩm");
        this.descriptions = sc.nextLine();

        System.out.println("Mời bạn nhập trạng thái [true/false]");
        this.catalogStatus= sc.nextBoolean();
    }


    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục sản phẩm: %s\n", this.catalogId, this.catalogName);

    }
}

