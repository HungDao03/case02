package phoneManager;

import java.util.List;

public class PhoneSort {

    // Phương thức sắp xếp theo giá tiền
    public static void sortPhonesByPrice() {
        List<String> phones = new PhoneOperations().readPhones(); // Đọc danh sách điện thoại từ file

        // Sử dụng thuật toán Selection Sort để sắp xếp theo giá
        for (int i = 0; i < phones.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < phones.size(); j++) {
                String[] data1 = phones.get(minIndex).split(",");
                String[] data2 = phones.get(j).split(",");
                double price1 = Double.parseDouble(data1[2].trim());  // Giá điện thoại trong cột thứ 3
                double price2 = Double.parseDouble(data2[2].trim());  // Giá điện thoại trong cột thứ 3

                // Nếu giá của điện thoại thứ j nhỏ hơn giá của điện thoại tại minIndex, đổi chỗ
                if (price2 < price1) {
                    minIndex = j;
                }
            }
            // Hoán đổi các dòng trong danh sách
            String temp = phones.get(i);
            phones.set(i, phones.get(minIndex));
            phones.set(minIndex, temp);
        }

        // Hiển thị kết quả sau khi sắp xếp
        System.out.println("Danh sách điện thoại sau khi sắp xếp theo giá:");
        for (String phone : phones) {
            System.out.println(phone);
        }
    }
}