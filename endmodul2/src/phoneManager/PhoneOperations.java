package phoneManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// thao tác đọc ghi sửa xóa
public class PhoneOperations {
    private static final String FILE_PATH = "data/mobiles.csv";
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            PhoneMenu.displayMenu();
            int choice = Integer.parseInt(PhoneMenu.getInput());

            switch (choice) {
                case 1:
                    PhoneAdder.addPhone();
                    break;
                case 2:
                    PhoneDeleter.deletePhone();
                    break;
                case 3:
                    PhoneViewer.viewPhones();
                    break;
                case 4:
//                    PhoneSearcher.searchPhone();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // tao id moi cho dien thoai dua tren id lon nhat
    public int getNextId() {
        int id = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                id = Math.max(id, Integer.parseInt(data[0]) + 1);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
        return id;
    }

    // ghi them dong moi vao file
    public void writeToFile(String phoneData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(phoneData);
            writer.newLine();
            System.out.println("Thêm mới thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    // doc tung noi dung và trả ra danh sách các dòng
    public List<String> readPhones() {
        List<String> phones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                phones.add(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
        return phones;
    }

    // ghi lại danh sách điện thoại vào file, dùng trong trường hợp cập nhật toàn bộ file sau khi xóa mục
    public void writePhones(List<String> phones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String phone : phones) {
                writer.write(phone);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }
}
