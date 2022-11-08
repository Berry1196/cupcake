package dat.backend.model.persistence;

import dat.backend.model.entities.Topping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToppingMapper {

    public static List<Topping> getToppings(ConnectionPool connectionPool) {
        List<Topping> toppingList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {

            String sql = "SELECT * FROM topping";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("topping_id");
                    String name = rs.getString("topping_name");
                    int price = rs.getInt("topping_price");

                    Topping topping = new Topping(id, name,price);
                    toppingList.add(topping);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toppingList;
    }
}
