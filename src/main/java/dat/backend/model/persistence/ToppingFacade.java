package dat.backend.model.persistence;

import dat.backend.model.entities.Topping;

import java.util.Map;

public class ToppingFacade {

    public static Map<String , Topping> getToppings(ConnectionPool connectionPool) {
        return ToppingMapper.getToppings(connectionPool);
    }

}
