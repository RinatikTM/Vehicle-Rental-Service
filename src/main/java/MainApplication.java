import io.javalin.Javalin;
import java.util.List;

public class MainApplication { // Класс обязателен
    public static void main(String[] args) { // Метод main обязателен
        DatabaseManager db = new DatabaseManager();

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        }).start(8080);

        app.get("/api/vehicles", ctx -> {
            List<Vehicle> vehicles = db.getAllVehicles();
            ctx.json(vehicles);
        });

        app.post("/api/rent", ctx -> {
            String idParam = ctx.queryParam("id");
            if (idParam == null) {
                ctx.status(400).result("Missing ID parameter");
                return;
            }
            int carId = Integer.parseInt(idParam);
            db.updateAvailability(carId, false);
            ctx.result("Vehicle with ID " + carId + " has been rented!");
        });

        System.out.println("Server is running on http://localhost:8080");
    }
}