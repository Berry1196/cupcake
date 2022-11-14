package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Order {
    private int order_id;
    private String username;
    private Timestamp date;
    private Boolean done;
    private ArrayList<Cake> cakeArrayList;

    public Order(int order_id, String username, Timestamp date, Boolean done) {
        this.order_id = order_id;
        this.username = username;
        this.date = date;
        this.done = done;
    }

    public Order(int order_id, String username, Timestamp date, Boolean done, ArrayList<Cake> cakeArrayList) {
        this.order_id = order_id;
        this.username = username;
        this.date = date;
        this.done = done;
        this.cakeArrayList = cakeArrayList;

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

    public ArrayList<Cake> getCakeArrayList() {
        return cakeArrayList;
    }

    public void setCakeArrayList(ArrayList<Cake> cakeArrayList) {
        this.cakeArrayList = cakeArrayList;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}

