package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BottomMapper {

    public static List<Bottom> getBottoms(ConnectionPool connectionPool) {
        List<Bottom> bottomList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {

            String sql = "SELECT * FROM bottom";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    String bottomName = rs.getString("bottom_name");
                    int bottomPrice = rs.getInt("bottom_price");

                    Bottom bottom = new Bottom(bottomId, bottomName, bottomPrice);
                    bottomList.add(bottom);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bottomList;
    }
}
