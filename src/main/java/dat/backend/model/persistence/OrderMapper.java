package dat.backend.model.persistence;

import com.mysql.cj.Session;
import dat.backend.model.entities.*;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;


public class OrderMapper {

    static List<Order> getOrders(ConnectionPool connectionPool) {
        List<Order> orderList = new ArrayList<>();
        ArrayList<Cake> cakeList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.order order by order_id";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("order_id");
                    String name = rs.getString("username");
                    Timestamp date = rs.getTimestamp("date");
                    Boolean done = rs.getBoolean("done");

                    Order newOrder = new Order(id, name, date, done, cakeList);
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
                "inner join cupcake.topping t on t.topping_id = ol.topping_id order by o.order_id";

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


    public static int saveOrderToOrdernline(int order_id, Cake cake, ConnectionPool connectionPool) {

        String sql = " insert into cupcake.orderline (order_id, bottom_id, topping_id, quantity, total_price) value (?,?,?,?,?)";


        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.setInt(2, cake.getBottom().getBottomId());
                ps.setInt(3, cake.getTopping().getToppingId());
                ps.setInt(4, cake.getQuantity());
                ps.setInt(5, cake.getTotalCakePrice());
                ps.executeUpdate();

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupcake_id = rs.getInt("cupcake_id");
                    return cupcake_id;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    public static Map<ShoppingCart, Order> getOrderListUser(String username, ConnectionPool connectionPool) {
        Map<ShoppingCart, Order> userOrderMap = new HashMap<>();

        String sql = "SELECT o.date, o.order_id, u.username, b.bottom_name, b.bottom_id, b.bottom_price, t.topping_name, t.topping_price,  t.topping_id, ol.quantity, ol.total_price, o.done FROM cupcake.order o\n" +
                "                inner join cupcake.user u on u.username = o.username\n" +
                "                inner join cupcake.orderline ol on o.order_id = ol.order_id\n" +
                "                inner join cupcake.bottom b on b.bottom_id = ol.bottom_id\n" +
                "                inner join cupcake.topping t on t.topping_id = ol.topping_id\n" +
                "                WHERE u.username = ?";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
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

                    userOrderMap.put(shoppingCart, order);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOrderMap;


    }


    public static  Map<Order, List<Cake>>  getOrderListForAdminByOrderId(int order_id, ConnectionPool connectionPool) {

        List<Cake> cakeList = new ArrayList<>();
        Map<Order, List<Cake>> adminOrderMap = new HashMap<>();

        String sql = "SELECT o.order_id, o.date, u.username, b.bottom_name, b.bottom_id, b.bottom_price, t.topping_name, t.topping_id, t.topping_price, ol.quantity, ol.total_price, o.done FROM cupcake.order o \n" +
                "inner join cupcake.user u on u.username = o.username\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id \n" +
                "inner join cupcake.bottom b on b.bottom_id = ol.bottom_id\n" +
                "inner join cupcake.topping t on t.topping_id = ol.topping_id\n" +
                "where ol.order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
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

                    Cake cake = new Cake(new Bottom(bottomId, bottomName, bottomPrice), new Topping(toppingId, toppingName, toppingPrice), quantity);
                    cakeList.add(cake);

                    Order order = new Order(id, name, date, done);

                    adminOrderMap.put(order, cakeList);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminOrderMap;

    }

    public static Map<Integer, Cake> getCakeByCupcakeId(int cupcake_id, ConnectionPool connectionPool) {

        Map<Integer, Cake> cakeList = new HashMap<>();

        String sql = "SELECT o.order_id, o.date, u.username, b.bottom_name, b.bottom_id, b.bottom_price, t.topping_name, t.topping_id, t.topping_price, ol.quantity, ol.total_price, o.done FROM cupcake.order o \n" +
                "inner join cupcake.user u on u.username = o.username\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id \n" +
                "inner join cupcake.bottom b on b.bottom_id = ol.bottom_id\n" +
                "inner join cupcake.topping t on t.topping_id = ol.topping_id\n" +
                "where ol.cupcake_id = ?";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cupcake_id);
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

                    Cake cake = new Cake(new Bottom(bottomId, bottomName, bottomPrice), new Topping(toppingId, toppingName, toppingPrice), quantity);
                    cakeList.put(cupcake_id, cake);
                    return cakeList;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<Integer, Integer> getCupcakeIdListByOrderId(int order_id, ConnectionPool connectionPool) {
        Map<Integer, Integer> cupcakeIdList = new HashMap<>();

        String sql = "SELECT cupcake_id from cupcake.orderline where order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int cupcakeId = rs.getInt("cupcake_id");
                    cupcakeIdList.put(order_id, cupcakeId);
                }
                return cupcakeIdList;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Map<Integer, Order> getMalene(ConnectionPool connectionPool) {

        List<Order> orderList = OrderFacade.getOrders(connectionPool);
        ArrayList<Cake> cakeList = new ArrayList<>();

        Map<Integer, Order> orderMap = new TreeMap<>();

        List<Cake> niksKager = new ArrayList<>();

        String sql = "SELECT o.date, o.order_id, u.username, b.bottom_name, b.bottom_id, b.bottom_price, t.topping_name, t.topping_price,  t.topping_id, ol.quantity, ol.total_price, o.done FROM cupcake.order o \n" +
                "inner join cupcake.user u on u.username = o.username\n" +
                "inner join cupcake.orderline ol on o.order_id = ol.order_id \n" +
                "inner join cupcake.bottom b on b.bottom_id = ol.bottom_id\n" +
                "inner join cupcake.topping t on t.topping_id = ol.topping_id order by o.order_id";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
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

//                    Cake cake = new Cake(new Bottom(bottomId, bottomName, bottomPrice), new Topping(toppingId, toppingName, toppingPrice), quantity);
//                    niksKager.add(cake);
//
//                    Order order = new Order(id, name, date, done);
//                    orderMap.put(order.getOrder_id(), order);

                    for (int i = 0; i < getOrders(connectionPool).size()-1; i++) {
                        int orderIdFromDb = getOrders(connectionPool).get(i).getOrder_id();
                        Order order = new Order(orderIdFromDb, name, date, done, cakeList);

                        if(orderIdFromDb == id) {
                            Cake cake = new Cake(new Bottom(bottomId, bottomName, bottomPrice), new Topping(toppingId, toppingName, toppingPrice), quantity);
                            order.getCakeArrayList().add(cake);
                        }
                        orderMap.put(orderIdFromDb, order);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderMap;
    }





}
