package dat.backend.model.persistence;


import dat.backend.model.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    static List<Order> getOrders(ConnectionPool connectionPool) {
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM order";

        try(Connection connection = connectionPool.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");

                    Order newOrder = new Order(id,name,date);
                    orderList.add(newOrder);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
