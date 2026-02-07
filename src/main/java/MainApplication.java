import io.javalin.Javalin;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        }).start(8080);

        app.get("/api/vehicles", ctx -> {
            List<Vehicle> vehicles = db.getAllVehicles();
            ctx.json(vehicles);
        });

        app.get("/", ctx -> ctx.result("Vehicle Rental API is running!"));

        app.post("/api/rent", ctx -> {

            int carId = ctx.queryParamAsClass("id", Integer.class)
                    .check(id -> id > 0, "ID must be greater than 0")
                    .get();

            db.updateAvailability(carId, false);

            ctx.json(new ResponseMessage("Vehicle " + carId + " rented successfully!"));
        });

        System.out.println("Server is running on http://localhost:8080");
    }

}

class ResponseMessage {
    public String message;
    public ResponseMessage(String m) { this.message = m; }
}