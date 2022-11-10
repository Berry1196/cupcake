package dat.backend.model.entities;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Cake> cakesInCart = new ArrayList<>();
    private int totalCartPrice = 0;

    public ShoppingCart() {
        this.cakesInCart = cakesInCart;
        this.totalCartPrice = totalCartPrice;
    }

    public ArrayList<Cake> insertCake(Cake cake) {
        cakesInCart.add(cake);

        int i = cakesInCart.indexOf(cake);
        cake.setCakeIndex(i);

        cake.setCakePrice();

        cake.setTotalCakePrice();

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

    public Cake getCakeByIndex(int cakeIndex) {
        return cakesInCart.get(cakeIndex);
    }


}


