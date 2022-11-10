package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomMapper {

    public static Map<String , Bottom> getBottoms(ConnectionPool connectionPool) {
        Map<String , Bottom> bottomMap = new TreeMap<>();
        //List<Bottom> bottomList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {

            String sql = "SELECT * FROM bottom";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    String bottomName = rs.getString("bottom_name");
                    int bottomPrice = rs.getInt("bottom_price");

                    Bottom bottom = new Bottom(bottomId, bottomName, bottomPrice);
                    bottomMap.put(bottomName, bottom);
                    //bottomList.add(bottom);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bottomMap;
    }

}
