package dat.backend.model.persistence;

import dat.backend.model.entities.Cake;
import dat.backend.model.entities.ShoppingCart;

public class CartMapper {
    public static Cake getCakeByIndex(int cakeIndex) {
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCart.getCakeByIndex(cakeIndex);





    }
}
