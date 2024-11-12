package phoneManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneOperations {
    private static final String FILE_PATH = "endmodul2/Data/mobiles.csv";
    private static final Scanner scanner = new Scanner(System.in);

    // Biến thể hiện duy nhất của lớp
    private static PhoneOperations instance;

    // Constructor private để ngăn không cho tạo đối tượng ngoài getInstance()
    PhoneOperations() {}

    // Phương thức để lấy thể hiện duy nhất của PhoneOperations
    public static PhoneOperations getInstance() {
        if (instance == null) {
            instance = new PhoneOperations();
        }
        return instance;
    }

    // Phương thức để bắt đầu chương trình
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

    // Tạo ID mới cho điện thoại dựa trên ID lớn nhất hiện tại trong file
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

    // Ghi thêm một dòng mới vào file
    public void writeToFile(String phoneData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(phoneData);
            writer.newLine();
            System.out.println("Thêm mới thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    // Đọc tất cả các dòng trong file và trả về danh sách các dòng
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

    // Ghi lại toàn bộ danh sách điện thoại vào file, dùng khi cập nhật dữ liệu
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
