package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.util.List;
import java.util.Map;

public class BottomFacade {

    public static Map<String , Bottom> getBottoms(ConnectionPool connectionPool) {
        return BottomMapper.getBottoms(connectionPool);
    }

}
