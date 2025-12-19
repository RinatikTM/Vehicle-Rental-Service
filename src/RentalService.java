public class RentalService {
    private String companyName;

    public RentalService(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    // Метод для сравнения
    public void compareVehicles(Vehicle v1, Vehicle v2) {
        System.out.println("Comparing " + v1.getBrand() + " and " + v2.getBrand());
        if (v1.getId() != v2.getId()) {
            System.out.println("These are different vehicles.");
        }
    }
}