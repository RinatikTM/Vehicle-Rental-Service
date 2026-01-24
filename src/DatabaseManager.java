import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost:5432/Rental Vechile System";
    private final String user = "postgres";
    private final String password = "Rr2878";

    // Получаем список всех машин из БД
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                int catId = rs.getInt("category_id");

                // Определяем текст категории по её ID (временно, пока нет JOIN)
                String categoryName = (catId == 1) ? "Economy" : (catId == 2) ? "Sport" : "Premium";

                vehicles.add(new Vehicle(id, brand, model, price, categoryName, catId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Обновляем статус машины в БД при аренде
    public void updateAvailability(int vehicleId, boolean available) {
        String query = "UPDATE vehicles SET available = ? WHERE vehicle_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, available);
            pstmt.setInt(2, vehicleId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}