package products;

public abstract class Phone {
    protected String id;
    protected String name;
    protected double price;
    protected int quantity;                // sluong
    protected String manufacturer;  // ng san xuat

    public Phone(String id, String name, double price, int quantity, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public abstract void displayDetails();

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
