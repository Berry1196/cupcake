package dat.backend.model.persistence;

import dat.backend.model.entities.Topping;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class ToppingMapper {

    public static Map<String, Topping> getToppings(ConnectionPool connectionPool) {
        Map<String, Topping> toppingMap = new TreeMap<>();
        try (Connection connection = connectionPool.getConnection()) {

            String sql = "SELECT * FROM topping";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int toppingId = rs.getInt("topping_id");
                    String toppingName = rs.getString("topping_name");
                    int toppingPrice = rs.getInt("topping_price");

                    Topping topping = new Topping(toppingId, toppingName, toppingPrice);
                    toppingMap.put(toppingName, topping);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toppingMap;
    }
}
