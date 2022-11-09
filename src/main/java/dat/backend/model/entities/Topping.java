package dat.backend.model.entities;

public class Topping {

    private int toppingId;
    String toppingName;
    int topppingPrice;

    public Topping(int toppingId, String toppingName, int topppingPrice) {
        this.toppingName = toppingName;
        this.topppingPrice = topppingPrice;
        this.toppingId = toppingId;
    }

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "toppingId=" + toppingId +
                ", toppingName='" + toppingName + '\'' +
                ", topppingPrice=" + topppingPrice +
                '}';
    }

    public int getToppingId() {
        return toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public int getTopppingPrice() {
        return topppingPrice;
    }
}
