package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class OrderMapper {
    static List<Order> getOrders(ConnectionPool connectionPool) {
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.order";

        try(Connection connection = connectionPool.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order newOrder = new Order(id,name,date, done);
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


    static List<Order> getOrderListByUsername(String username, ConnectionPool connectionPool) {
        List<Order> orderList = new ArrayList<>();

        String sql = "select * from cupcake.order where username = ?";

        try(Connection connection = connectionPool.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int order_id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order newOrder = new Order(order_id, name, date, done);
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

    static Order getOrderByUsername(String username, ConnectionPool connectionPool) {

        String sql = "select * from cupcake.order where username = ? order by order_id desc";

        try(Connection connection = connectionPool.getConnection()) {

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int order_id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order newOrder = new Order(order_id, name, date, done);
                    return newOrder;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Order> saveOrder(String username, ConnectionPool connectionPool) {

        String sql = "insert into cupcake.order (username) values (?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.executeUpdate();

                List<Order> orderList = getOrderListByUsername(username, connectionPool);
                return orderList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




}
