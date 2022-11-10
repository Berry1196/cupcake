package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.util.List;

public class OrderFacade {
    public static List<Order> getOrders(ConnectionPool connectionPool) {
        return OrderMapper.getOrders(connectionPool);
    }
}
