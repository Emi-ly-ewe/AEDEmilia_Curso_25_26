package org.emiliaargibayafonso.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneroDAO implements InterfazDAO {
    @Override
    public void retrieveAll(Connection conexion) {
        String sqlSelect = "SELECT * FROM genres";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = pdstmt.executeQuery(sqlSelect);
            while (rs.next()) {
                System.out.println("ReviewID: "+rs.getInt("reviewid")+" | Género: "+rs.getString("genre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
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
