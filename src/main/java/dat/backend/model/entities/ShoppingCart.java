package dat.backend.model.entities;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Cake> cakesInCart = new ArrayList<>();




    private int totalCartPrice = 0;

    public ShoppingCart() {
        this.cakesInCart = cakesInCart;
        this.totalCartPrice = totalCartPrice;
        insertCake(new Cake(new Bottom(1, "chocolate", 5), new Topping(9, "blue cheese", 9), 3));

        insertCake(new Cake(new Bottom(2, "vanilla", 5), new Topping(9, "kiks", 14), 7));
        //totalCartPrice = cakesInCart.get(0).getTotalCakePrice() + cakesInCart.get(1).getTotalCakePrice();
    }


    public ArrayList<Cake> insertCake(Cake cake) {
        cakesInCart.add(cake);

        int i = cakesInCart.indexOf(cake);
        cake.setCakeIndex(i);

        totalCartPrice += cake.getTotalCakePrice();

        return cakesInCart;
    }

    public ArrayList<Cake> removeCake(int cakeId) {
        cakesInCart.remove(cakeId);
        return cakesInCart;
    }

    public ArrayList<Cake> getCakesInCart() {
        return cakesInCart;
    }
    public int getTotalCartPrice() {
        return totalCartPrice;
    }

}


