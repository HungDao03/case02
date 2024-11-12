package products;
// dien thoai xach tay
public class HandCarriedPhone extends Phone {
    private String country; // luu tru quoc gia
    private String condition;  // luu tru tinh trang dien thoai

    public HandCarriedPhone(String id, String name, double price, int quantity, String manufacturer, String country, String condition) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.condition = condition;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", Price: " + getPrice() +
                ", Quantity: " + getQuantity() + ", Manufacturer: " + getManufacturer() +
                ", Country: " + country + ", Condition: " + condition);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
