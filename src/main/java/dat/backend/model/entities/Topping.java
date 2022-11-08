package dat.backend.model.entities;

public class Topping {

    private int toppingId;
    String toppingName;
    int topppingPrice;

    public Topping(String toppingName, int topppingPrice) {
        this.toppingName = toppingName;
        this.topppingPrice = topppingPrice;
    }
}
