static int count = 0;

void main() {
    Scanner scanner = new Scanner(System.in);

    // 1. Создаем сервис аренды (Пункт 9)
    RentalService rentalService = new RentalService("City Car Rental");

    // 2. Добавляем ввод имени клиента с клавиатуры
    IO.println("Enter your name:");
    String userName = scanner.nextLine(); // Программа будет ждать, пока ты введешь имя
    Client client = new Client(101, userName);

    IO.println("Hello, " + client.getName() + "! Welcome to " + rentalService.getCompanyName());

    // Машины
    // эконом
    Vehicle eco1 = new Vehicle(1, "Toyota", "Corolla", 100, "economy");
    Vehicle eco2 = new Vehicle(2, "Hyunday", "Accent", 150, "economy");
    Vehicle eco3 = new Vehicle(3, "Chevrolet", "monza", 200, "economy");
    // спорт
    Vehicle sport1 = new Vehicle(4, "BMW", "M4", 300, "sport");
    Vehicle sport2 = new Vehicle(5, "AUDI", "RS7", 400, "sport");
    Vehicle sport3 = new Vehicle(6, "Porshe", "911", 500, "sport");
    // премиум
    Vehicle prem1 = new Vehicle(7, "Mercedes", "S-Class", 600, "premium");
    Vehicle prem2 = new Vehicle(8, "Lexus", "LS", 550, "premium");
    Vehicle prem3 = new Vehicle(9, "Rolse Royse", "Phantom", 1000, "premium");

    // 2. Сравнение объектов перед началом работы (Пункт 10)
    IO.println("--- System Check: Comparing car prices ---");
    if (eco1.getId() != eco2.getId()) {
        IO.println("Comparison: " + eco1.brand + " and " + eco2.brand + " are different objects.");
    }
    IO.println("------------------------------------------\n");

    IO.println("Welcome to " + rentalService.getCompanyName());
    IO.println("Client: " + client.getName());

    // Выбор категории
    IO.println("Choose category:");
    IO.println("1 - Economy");
    IO.println("2 - Sport");
    IO.println("3 - Premium");

    int categoryChoice = scanner.nextInt();

    // Показ машин выбранной категории
    if (categoryChoice == 1) {
        IO.println("Economy cars:");
        IO.println(eco1);
        IO.println(eco2);
        IO.println(eco3);
    } else if (categoryChoice == 2) {
        IO.println("Sport cars:");
        IO.println(sport1);
        IO.println(sport2);
        IO.println(sport3);
    } else if (categoryChoice == 3) {
        IO.println("Premium cars:");
        IO.println(prem1);
        IO.println(prem2);
        IO.println(prem3);
    } else {
        IO.println("Wrong category");
        return;
    }

    // Выбор машины
    IO.println("Choose car id:");
    int carChoice = scanner.nextInt();

    if (carChoice <= 3 && carChoice >= 1) {
        if (carChoice == eco1.getId()) {
            if (eco1.isAvailable()) {
                eco1.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + eco1);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == eco2.getId()) {
            if (eco2.isAvailable()) {
                eco2.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + eco2);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == eco3.getId()) {
            if (eco3.isAvailable()) {
                eco3.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + eco3);
            } else {
                IO.println("This car is already rented");
            }
        }
    }
    if (carChoice > 3 && carChoice <= 6) {
        if (carChoice == sport1.getId()) {
            if (sport1.isAvailable()) {
                sport1.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + sport1);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == sport2.getId()) {
            if (sport2.isAvailable()) {
                sport2.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + sport2);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == sport3.getId()) {
            if (sport3.isAvailable()) {
                sport3.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + sport3);
            } else {
                IO.println("This car is already rented");
            }
        }
    }
    if (carChoice > 6 && carChoice <= 9) {
        if (carChoice == prem1.getId()) {
            if (prem1.isAvailable()) {
                prem1.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + prem1);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == prem2.getId()) {
            if (prem2.isAvailable()) {
                prem2.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + prem2);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == prem3.getId()) {
            if (prem3.isAvailable()) {
                prem3.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + prem3);
            } else {
                IO.println("This car is already rented");
            }
        }
    } else {
        count = 1;
        IO.println("Car not found");
    }
}

public static void processRent(Vehicle vehicle, Client client, int count) {
    if (count == 0) {
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            IO.println(client.getName() + ", you rented: " + vehicle);
        } else {
            IO.println("This car is already rented");
        }
    } else {
        IO.println("This car not this category");
    }
}