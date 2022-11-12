package dat.backend.model.persistence;

import com.mysql.cj.Session;
import dat.backend.model.entities.*;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;


public class OrderMapper {

    static List<Order> getOrders(ConnectionPool connectionPool) {
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.order";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order newOrder = new Order(id, name, date, done);
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

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order order = new Order(order_id, name, date, done);

                    orderList.add(order);

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

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
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


    public static Map<ShoppingCart, Order> getOrderListForAdmin(ConnectionPool connectionPool) {

        Map<ShoppingCart, Order> adminOrderMap = new HashMap<>();

        String sql = "SELECT o.date, o.order_id, u.username, b.bottom_name, b.bottom_id, b.bottom_price, t.topping_name, t.topping_price,  t.topping_id, ol.quantity, ol.total_price, o.done FROM cupcake.order o \n" +
                "inner join cupcake.user u on u.username = o.username\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id \n" +
                "inner join cupcake.bottom b on b.bottom_id = ol.bottom_id\n" +
                "inner join cupcake.topping t on t.topping_id = ol.topping_id";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    String bottomName = rs.getString("bottom_name");
                    String toppingName = rs.getString("topping_name");
                    int quantity = rs.getInt("quantity");
                    int bottomId = rs.getInt("bottom_id");
                    int bottomPrice = rs.getInt("bottom_price");
                    int toppingPrice = rs.getInt("topping_price");
                    int toppingId = rs.getInt("topping_id");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");


                    ShoppingCart shoppingCart = new ShoppingCart();
                    Cake cake = new Cake(new Bottom(bottomId, bottomName, bottomPrice), new Topping(toppingId, toppingName, toppingPrice), quantity);
                    shoppingCart.insertCake(cake);
                    shoppingCart.getTotalCartPrice();

                    Order order = new Order(id, name, date, done);

                    adminOrderMap.put(shoppingCart, order);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminOrderMap;
    }


    public static void saveOrderToOrdernline(int order_id, Cake cake, ConnectionPool connectionPool) {

        String sql = " insert into cupcake.orderline (order_id, bottom_id, topping_id, quantity, total_price value (?,?,?,?,?))";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.setInt(2, cake.getBottom().getBottomId());
                ps.setInt(3, cake.getTopping().getToppingId());
                ps.setInt(4, cake.getQuantity());
                ps.setInt(5, cake.getTotalCakePrice());
                ps.executeUpdate();

                // List<Order> orderList = getOrderListByUsername(username, connectionPool);
                // return orderList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void toggleItem(int order_id, ConnectionPool connectionPool) {
        String sql = "UPDATE cupcake.order SET done = 1 - done WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
