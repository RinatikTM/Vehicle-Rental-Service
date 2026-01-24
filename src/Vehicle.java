public class Vehicle {
    private final int car_id;
    final String brand;
    private final String model;
    private final int price;
    private final String category;
    private final int category_id;
    private boolean available;

    public Vehicle(int car_id, String brand, String model, int price, String category, int category_id) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.category = category;
        this.available = true;
        this.category_id = category_id;
    }

    public int getId() { return car_id; }

    public String getBrand() { return brand; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Vehicle [id = " + car_id + ", category = " + category + ", Brand = " + brand + ", Model = " + model +
                ", Price = " + price + "]";
    }
}