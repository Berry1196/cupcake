package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;

import java.util.List;

public class ToppingFacade {

    public static List<Topping> getToppings(ConnectionPool connectionPool) {
        return ToppingMapper.getToppings(connectionPool);
    }

}
