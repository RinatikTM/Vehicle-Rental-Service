

void main() {
    Scanner scanner = new Scanner(System.in);

    // 1. Создаем сервис аренды (Пункт 9)
    RentalService rentalService = new RentalService("City Car Rental");

    // 2. Добавляем ввод имени клиента с клавиатуры
    System.out.println("Enter your name:");
    String userName = scanner.nextLine(); // Программа будет ждать, пока ты введешь имя
    Client client = new Client(101, userName);

    System.out.println("Hello, " + client.getName() + "! Welcome to " + rentalService.getCompanyName());

    // Машины
    // эконом
    Vehicle eco1 = new Vehicle(1, "Toyota", "Corolla", 100, "economy", 1);
    Vehicle eco2 = new Vehicle(2, "Hyunday", "Accent", 150, "economy", 1);
    Vehicle eco3 = new Vehicle(3, "Chevrolet", "monza", 200, "economy", 1);
    // спорт
    Vehicle sport1 = new Vehicle(4, "BMW", "M4", 300, "sport", 2);
    Vehicle sport2 = new Vehicle(5, "AUDI", "RS7", 400, "sport", 2);
    Vehicle sport3 = new Vehicle(6, "Porshe", "911", 500, "sport", 2);
    // премиум
    Vehicle prem1 = new Vehicle(7, "Mercedes", "S-Class", 600, "premium", 3);
    Vehicle prem2 = new Vehicle(8, "Lexus", "LS", 550, "premium", 3);
    Vehicle prem3 = new Vehicle(9, "Rolse Royse", "Phantom", 1000, "premium", 3);

    // 2. Сравнение объектов перед началом работы (Пункт 10)
    System.out.println("--- System Check: Comparing car prices ---");
    if (eco1.getId() != eco2.getId()) {
        System.out.println("Comparison: " + eco1.brand + " and " + eco2.brand + " are different objects.");
    }
    System.out.println("------------------------------------------\n");

    System.out.println("Welcome to " + rentalService.getCompanyName());
    System.out.println("Client: " + client.getName());

    // Выбор категории
    System.out.println("Choose category:");
    System.out.println("1 - Economy");
    System.out.println("2 - Sport");
    System.out.println("3 - Premium");

    int categoryChoice = scanner.nextInt();

    // Показ машин выбранной категории
    if (categoryChoice == 1) {
        System.out.println("Economy cars:");
        System.out.println(eco1);
        System.out.println(eco2);
        System.out.println(eco3);
    } else if (categoryChoice == 2) {
        System.out.println("Sport cars:");
        System.out.println(sport1);
        System.out.println(sport2);
        System.out.println(sport3);
    } else if (categoryChoice == 3) {
        System.out.println("Premium cars:");
        System.out.println(prem1);
        System.out.println(prem2);
        System.out.println(prem3);
    } else {
        System.out.println("Wrong category");
        return;
    }

    // Выбор машины
    System.out.println("Choose car id:");
    int carChoice = scanner.nextInt();

    if (carChoice == eco1.getId()) {
        if (eco1.isAvailable()) {
            eco1.setAvailable(false);
            System.out.println(client.getName() + ", you rented: " + eco1);
        }
        else {
            System.out.println("This car is already rented");
        }
    }
    else if (carChoice == eco2.getId()) {
            if (eco2.isAvailable()) {
                eco2.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + eco2);
            } else {
                System.out.println("This car is already rented");
            }
        } else if (carChoice == eco3.getId()) {
            if (eco3.isAvailable()) {
                eco3.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + eco3);
            } else {
                System.out.println("This car is already rented");
            }
    }

        if (carChoice == sport1.getId()) {
            if (sport1.isAvailable()) {
                sport1.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + sport1);
            } else {
                System.out.println("This car is already rented");
            }
        } else if (carChoice == sport2.getId()) {
            if (sport2.isAvailable()) {
                sport2.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + sport2);
            } else {
                IO.println("This car is already rented");
            }
        } else if (carChoice == sport3.getId()) {
            if (sport3.isAvailable()) {
                sport3.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + sport3);
            } else {
                System.out.println("This car is already rented");
            }
        }

        if (carChoice == prem1.getId()) {
            if (prem1.isAvailable()) {
                prem1.setAvailable(false);
                IO.println(client.getName() + ", you rented: " + prem1);
            } else {
                System.out.println("This car is already rented");
            }
        } else if (carChoice == prem2.getId()) {
            if (prem2.isAvailable()) {
                prem2.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + prem2);
            } else {
                System.out.println("This car is already rented");
            }
        } else if (carChoice == prem3.getId()) {
            if (prem3.isAvailable()) {
                prem3.setAvailable(false);
                System.out.println(client.getName() + ", you rented: " + prem3);
            } else {
                System.out.println("This car is already rented");
            }
    } else {
        System.out.println("Car not found");
    }
}

public static void processRent(Vehicle vehicle, Client client, int count) {
    if (count == 0) {
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            System.out.println(client.getName() + ", you rented: " + vehicle);
        } else {
            System.out.println("This car is already rented");
        }
    } else {
        System.out.println("This car not this category");
    }
}