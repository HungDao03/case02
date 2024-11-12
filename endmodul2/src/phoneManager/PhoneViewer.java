package phoneManager;

import java.util.List;
// xem danh sach dien thoai (doc tu file va hien thi danh sach dien thoai co trong file)
public class PhoneViewer {
    public static void viewPhones() {
        List<String> phones = new PhoneOperations().readPhones();
        System.out.println("Danh sách điện thoại:");
        for (String phone : phones) {
            System.out.println(phone);
        }
    }
}
