package dat.backend.model.persistence;

import dat.backend.model.entities.Cake;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderFacade {

    public static List<Order> getOrders(ConnectionPool connectionPool) {
        return OrderMapper.getOrders(connectionPool);
    }

    public static List<Order> getOrderListByUsername(String username, ConnectionPool connectionPool) {
        return OrderMapper.getOrderListByUsername(username, connectionPool);
    }

    public static Order getOrderByUsername(String username, ConnectionPool connectionPool) {
        return OrderMapper.getOrderByUsername(username, connectionPool);
    }

    public static void saveOrder(String username, ConnectionPool connectionPool) {
        OrderMapper.saveOrder(username, connectionPool);
    }

    public static Map<ShoppingCart, Order> getOrderListForAdmin(ConnectionPool connectionPool) {
        return OrderMapper.getOrderListForAdmin(connectionPool);
    }

    public static void saveOrderToOrdernline(int order_id, Cake cake, ConnectionPool connectionPool) {
       OrderMapper.saveOrderToOrdernline(order_id, cake, connectionPool);
    }

    public static void toggleItem(int order_id, ConnectionPool connectionPool) {
        OrderMapper.toggleItem(order_id, connectionPool);
    }
}
