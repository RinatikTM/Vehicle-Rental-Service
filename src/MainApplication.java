public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DatabaseManager db = new DatabaseManager();
    RentalService rentalService = new RentalService("City Car Rental");

    // 1. Загружаем все машины из БД
    List<Vehicle> allVehicles = db.getAllVehicles();

    System.out.println("Enter your name:");
    String userName = scanner.nextLine();
    Client client = new Client(101, userName);

    System.out.println("Welcome, " + client.getName() + "!");
    System.out.println("Choose category: 1-Economy, 2-Sport, 3-Premium");
    int categoryChoice = scanner.nextInt();

    // 2. Фильтруем машины по выбранной категории (через category_id)
    System.out.println("Available cars:");
    for (Vehicle v : allVehicles) {
        if (v.getCategoryId() == categoryChoice) {
            System.out.println(v);
        }
    }

    // 3. Выбор машины
    System.out.println("Enter car ID to rent:");
    int carChoice = scanner.nextInt();

    Vehicle selectedVehicle = null;
    for (Vehicle v : allVehicles) {
        if (v.getId() == carChoice) {
            selectedVehicle = v;
            break;
        }
    }

    // 4. Логика аренды
    if (selectedVehicle != null) {
        if (selectedVehicle.isAvailable()) {
            // Обновляем и в объекте, и в базе данных!
            selectedVehicle.setAvailable(false);
            db.updateAvailability(selectedVehicle.getId(), false);

            System.out.println("Success! You rented " + selectedVehicle.getBrand());
        } else {
            System.out.println("Already rented.");
        }
    } else {
        System.out.println("Car not found.");
    }
}