package dat.backend.model.entities;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Cake> cakesInCart = new ArrayList<>();

    public ShoppingCart() {
        this.cakesInCart = cakesInCart;
        insertCake(new Cake(new Bottom(1, "chocolate", 5), new Topping(9, "blue cheese", 9), 3));
        insertCake(new Cake(new Bottom(2, "vanilla", 5), new Topping(9, "kiks", 14), 7));
    }

    public ArrayList<Cake> insertCake(Cake cake) {
        cakesInCart.add(cake);
        return cakesInCart;
    }

    public ArrayList<Cake> removeCake(int cakeId) {
        cakesInCart.remove(cakeId);
        return cakesInCart;
    }

    public ArrayList<Cake> getCakesInCart() {
        return cakesInCart;
    }
}
