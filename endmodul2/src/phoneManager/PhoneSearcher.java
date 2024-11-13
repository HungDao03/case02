package phoneManager;

import products.Phone;
import java.util.List;
import java.util.Scanner;

public class PhoneSearcher {
    private static final Scanner scanner = new Scanner(System.in);

    public static void searchPhone() {
        System.out.print("Nhập ID điện thoại cần tìm: ");
        String searchId = scanner.nextLine().trim();

        // Kiểm tra nếu không có ID được nhập
        if (searchId.isEmpty()) {
            System.out.println("Không tồn tại ID.");
            return;
        }

        List<String> phones = new PhoneOperations().readPhones(); // Đọc danh sách điện thoại từ file
        boolean found = false;

        System.out.println("Kết quả tìm kiếm:");
        for (String phoneData : phones) {
            String[] data = phoneData.split("\\s*,\\s*");  // Tách từng dòng theo dấu phẩy, loại bỏ khoảng trắng dư thừa
            if (data.length > 0) {
                String id = data[0].trim();  // ID điện thoại là phần tử đầu tiên trong mảng dữ liệu
                if (id.equals(searchId)) {
                    System.out.println(phoneData);  // Hiển thị thông tin điện thoại tìm thấy
                    found = true;
                    break;  // Dừng vòng lặp khi tìm thấy kết quả
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại với ID: " + searchId);
        }
    }
}
