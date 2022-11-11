package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.util.List;

public class OrderFacade {
    public static List<Order> getOrders(ConnectionPool connectionPool) {
        return OrderMapper.getOrders(connectionPool);
    }

    public  static List<Order> getOrderByUsername(String username, ConnectionPool connectionPool) {
        return OrderMapper.getOrderByUsername(username, connectionPool);
    }

    public static void saveOrder(String username, ConnectionPool connectionPool) {
        OrderMapper.saveOrder(username, connectionPool);
    }
}
