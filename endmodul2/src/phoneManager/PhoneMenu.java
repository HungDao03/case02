package phoneManager;

import java.util.Scanner;
// hiện thỉ menu
public class PhoneMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.print("      <- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI ->" + "\n" +
                "Chọn  chức năng theo số (để tiếp tục)" + "\n" +
                "1. Thêm mới điện thoại" + "\n" +
                "2. Xóa điện thoại" + "\n" +
                "3. Xem danh sách điện thoại" + "\n" +
                "4. Tìm kiếm" + "\n" +
                "5. Sắp xếp theo giá tiền" + "\n" +  // Thêm lựa chọn sắp xếp
                "6. Thoát" + "\n" +
                "Chọn chức năng: ");
    }

    public static String getInput() {
        return scanner.nextLine();
    }
}
