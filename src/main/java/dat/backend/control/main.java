package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;

public class main {

    public static void main(String[] args) {
        ShoppingCart s = new ShoppingCart();
        System.out.println("størrelsen;" + s.getCakesInCart().size());
    }

}
