package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int order_id;
    private String username;
    private Timestamp date;

    public Order(int order_id, String username, Timestamp date) {
        this.order_id = order_id;
        this.username = username;
        this.date = date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getDate() {
        return date;
    }
}

