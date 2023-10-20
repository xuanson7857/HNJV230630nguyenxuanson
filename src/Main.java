

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static  Scanner scanner = new Scanner(System.in);
    static Queue<String> parentQueue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> parentQueue = new LinkedList<>();

        int choice = 0;

        while (choice != 3) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phụ huynh nộp hồ sơ: ");
                    String parentName = scanner.nextLine();
                    parentQueue.add(parentName);
                    break;
                case 2:
                    if (!parentQueue.isEmpty()) {
                        String nextParent = parentQueue.poll();
                        System.out.println("Phụ huynh đầu tiên trong danh sách: " + nextParent);
                    } else {
                        System.out.println("không có phụ huynh nào.");
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Xin hãy nhập lại sự lựa chọn");
                    break;
            }
        }

        scanner.close();
    }
}
