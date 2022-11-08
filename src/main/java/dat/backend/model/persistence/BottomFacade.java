package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.util.List;

public class BottomFacade {

    public static List<Bottom> getBottoms(ConnectionPool connectionPool) {
        return BottomMapper.getBottoms(connectionPool);
    }

}
