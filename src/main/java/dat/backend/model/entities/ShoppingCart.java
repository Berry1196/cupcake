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

    public ArrayList<Cake> getCakesInCart() {
        return cakesInCart;
    }

    public int getTotalCartPrice() {
        return totalCartPrice;
    }

    public Cake getCakeByIndex(int cakeIndex) {
        return cakesInCart.get(cakeIndex);
    }


    public void deleteCakeByIndex(int cakeIndex) {
        totalCartPrice -= cakesInCart.get(cakeIndex).getTotalCakePrice();
        cakesInCart.remove(cakeIndex);
        indexUpdate();
    }

    public void updateCake(int index, Cake cake) {
        totalCartPrice -= cakesInCart.get(index).getTotalCakePrice();
        cakesInCart.set(index, cake);
        totalCartPrice += cake.getTotalCakePrice();
        indexUpdate();
    }

    public void indexUpdate() {
        int index = 0;
        for (Cake cake : cakesInCart) {
            cake.setCakeIndex(index);
            index++;
        }

    }

}


