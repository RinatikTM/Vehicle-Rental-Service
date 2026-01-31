public void compareVehicles(Vehicle v1, Vehicle v2) {
    System.out.println("Comparing " + v1.getBrand() + " and " + v2.getBrand());
    if (v1.getCar_id() != v2.getCar_id()) {
        System.out.println("These are different vehicles.");
    }
}

void main() {
}