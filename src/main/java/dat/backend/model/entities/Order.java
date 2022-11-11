package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {
    private int order_id;
    private String username;
    private Timestamp date;
    private Boolean done;

    public Order(int order_id, String username, Timestamp date, Boolean done) {
        this.order_id = order_id;
        this.username = username;
        this.date = date;
        this.done = done;
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


    public Boolean getDone() {
        return done;
    }
}

