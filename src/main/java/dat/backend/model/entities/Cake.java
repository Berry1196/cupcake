package dat.backend.model.entities;

public class Cake {

    private Bottom bottom;
    private Topping topping;
    private int quantity;

    public Cake(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
    }


    public Bottom getBottom() {
        return bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public int getQuantity() {
        return quantity;
    }
}
