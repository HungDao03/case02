package application;

import phoneManager.PhoneOperations;

public class Main {
    public static void main(String[] args) {
        // Lấy thể hiện duy nhất của PhoneOperations bằng Singleton Pattern
        PhoneOperations phoneOperations = PhoneOperations.getInstance();

        // Gọi phương thức start() để bắt đầu chương trình
        phoneOperations.start();
    }
}
