package products;
// dien thoai chinh hang
public class GenuinePhone extends Phone {
    private int warrantyTime; // lưu tru tgian bao hanh
    private String warrantyRange;  // luu tru pvi bao hanh

    public GenuinePhone(String id, String name, double price, int quantity, String manufacturer, int warrantyTime, String warrantyRange) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyTime = warrantyTime;
        this.warrantyRange = warrantyRange;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", Price: " + getPrice() +
                ", Quantity: " + getQuantity() + ", Manufacturer: " + getManufacturer() +
                ", Warranty Time: " + warrantyTime + " months" + ", Warranty Range: " + warrantyRange);
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public String getWarrantyRange() {
        return warrantyRange;
    }

    public void setWarrantyRange(String warrantyRange) {
        this.warrantyRange = warrantyRange;
    }
}
