package dat.backend.model.entities;

public class Cake {

    private Bottom bottom;
    private Topping topping;
    private int quantity;



    private int cakePrice;



    private int totalCakePrice;

    public Cake(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        cakePrice = bottom.getBottomPrice() + topping.getTopppingPrice();
        totalCakePrice = (bottom.getBottomPrice() + topping.getTopppingPrice()) * quantity;
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

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getCakePrice() {
        return cakePrice;
    }
    public int getTotalCakePrice() {
        return totalCakePrice;
    }
}
