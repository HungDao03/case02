package phoneManager;

public class PhoneAdder {
    public static void addPhone() {
        System.out.print("Tên điện thoại: ");
        String name = PhoneMenu.getInput();  // Nhập tên điện thoại
        // Kiểm tra nếu tên trống hoặc chỉ chứa khoảng trắng
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên điện thoại không được để trống.");
            return;
        }

        // Giá bán
        System.out.print("Giá bán: ");
        double price;
        try {
            price = Double.parseDouble(PhoneMenu.getInput());  // Chuyển giá bán sang số thực
            if (price <= 0) {
                System.out.println("Giá bán phải là số dương.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Giá bán phải là một số hợp lệ.");
            return;
        }

        // Số lượng
        System.out.print("Số lượng: ");
        int quantity;
        try {
            quantity = Integer.parseInt(PhoneMenu.getInput());
            if (quantity <= 0) {
                System.out.println("Số lượng phải là số dương.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng phải là một số nguyên hợp lệ.");
            return;
        }

        // Nhà sản xuất
        System.out.print("Nhà sản xuất: ");
        String manufacturer = PhoneMenu.getInput();  // Nhập nhà sản xuất
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            System.out.println("Nhà sản xuất không được để trống.");
            return;
        }

        // Loại điện thoại
        System.out.print("Loại điện thoại (1: Chính hãng, 2: Xách tay): ");
        int type;
        try {
            type = Integer.parseInt(PhoneMenu.getInput());
            if (type != 1 && type != 2) {
                System.out.println("Loại điện thoại không hợp lệ. Vui lòng chọn lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loại điện thoại phải là 1 hoặc 2.");
            return;
        }

        // Tạo ID tự động cho điện thoại
        int id = new PhoneOperations().getNextId();  // Lấy ID tự động từ hệ thống
        String phoneData;

        switch (type) {
            case 1:  // Trường hợp điện thoại chính hãng
                // Thời gian bảo hành
                System.out.print("Thời gian bảo hành (Ngày): ");
                int warrantyTime;
                try {
                    warrantyTime = Integer.parseInt(PhoneMenu.getInput());  // Nhập thời gian bảo hành
                    if (warrantyTime <= 0 || warrantyTime > 730) {
                        System.out.println("Thời gian bảo hành phải là số dương và không vượt quá 730 ngày.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Thời gian bảo hành phải là một số nguyên hợp lệ.");
                    return;
                }

                // Phạm vi bảo hành
                System.out.print("Phạm vi bảo hành (Toan quoc/Quoc te): ");
                String warrantyRange = PhoneMenu.getInput();  // Nhập phạm vi bảo hành
                if (!warrantyRange.equalsIgnoreCase("Toan quoc") && !warrantyRange.equalsIgnoreCase("Quoc te")) {
                    System.out.println("Phạm vi bảo hành phải là 'Toan quoc' hoặc 'Quoc te'.");
                    return;
                }

                // Lưu dữ liệu điện thoại
                phoneData = String.format("%d,%s,%.2f,%d,%s,%d,%s",
                        id, name, price, quantity, manufacturer, warrantyTime, warrantyRange);
                break;

            case 2:  // Trường hợp điện thoại xách tay
                System.out.print("Quốc gia xách tay: ");
                String country = PhoneMenu.getInput();  // Nhập quốc gia xách tay
                // Kiểm tra nếu quốc gia xách tay trống
                if (country == null || country.trim().isEmpty()) {
                    System.out.println("Quốc gia xách tay không được để trống.");
                    return;
                }

                // Trạng thái
                System.out.print("Trạng thái (Da sua chua/Chua sua chua): ");
                String condition = PhoneMenu.getInput();  // Nhập trạng thái
                // Kiểm tra nếu trạng thái không hợp lệ
                if (!condition.equalsIgnoreCase("Da sua chua") && !condition.equalsIgnoreCase("Chua sua chua")) {
                    System.out.println("Trạng thái phải là 'Da sua chua' hoặc 'Chua sua chua'.");
                    return;
                }

                // Lưu dữ liệu điện thoại
                phoneData = String.format("%d,%s,%.2f,%d,%s,%s,%s",
                        id, name, price, quantity, manufacturer, country, condition);
                break;

            default:
                System.out.println("Loại điện thoại không hợp lệ. Vui lòng chọn lại.");
                return;
        }

        // Ghi dữ liệu vào file
        new PhoneOperations().writeToFile(phoneData);
        System.out.println("Thêm thành công.");
    }
}
