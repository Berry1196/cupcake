package dat.backend.model.entities;

public class Cake {

    private Bottom bottom;
    private Topping topping;
    private int quantity;
    private int cakePrice;
    private int totalCakePrice;
    private int cakeIndex;

    public Cake(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.cakeIndex = cakeIndex;
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
        return cakePrice = bottom.getBottomPrice() + topping.getTopppingPrice();
    }
    public int getTotalCakePrice() {
        return totalCakePrice = (bottom.getBottomPrice() + topping.getTopppingPrice()) * quantity;
    }

    public void setCakePrice() {
        this.cakePrice = bottom.getBottomPrice() + topping.getTopppingPrice();
    }
    public void setTotalCakePrice() {
        this.totalCakePrice = (bottom.getBottomPrice() + topping.getTopppingPrice()) * quantity;
    }



    public int getCakeIndex() {
        return cakeIndex;
    }

    public void setCakeIndex(int cakeIndex) {
        this.cakeIndex = cakeIndex;
    }




}
