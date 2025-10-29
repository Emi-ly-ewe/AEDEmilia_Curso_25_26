package org.emiliaargibayafonso.DAO;

import java.sql.PreparedStatement;

public class ReviewDAO implements InterfazDAO {
    @Override
    public void retrieveAll() {
        String sqlSelect = "SELECT * FROM reviews";
        try (PreparedStatement pdstmt = conexion) {

        }

        /*private static void selectAll(Connection connection) {
        String selectSQL = "SELECT id, name, age FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        * */
    }
    @Override
    public boolean insert() {
        return false;
    }
    @Override
    public boolean update() {
        return false;
    }
    @Override
    public boolean delete() {
        return false;
    }
}
