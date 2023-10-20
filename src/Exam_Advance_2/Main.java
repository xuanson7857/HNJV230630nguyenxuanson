package Exam_Advance_2;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Stack<String> word = new Stack<>();
    public static void main(String[] args) {

        int choice = 0;
        String str = "";
        while (choice != 3) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập câu: ");
                    str = scanner.nextLine();
                    break;
                case 2:
                    if (!str.isEmpty()) {
                        word = reverse(str);
                        System.out.print("Câu đảo ngược: ");
                        while (!word.isEmpty()) {
                            System.out.print(word.pop() + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Vui lòng nhập câu trước đó!");
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }

        scanner.close();
    }

    public static Stack<String> reverse(String str) {
        Stack<String> wordStack = new Stack<>();
        String[] words = str.split(" ");
        for (String word : words) {
            wordStack.push(word);
        }
        return wordStack;
    }
}