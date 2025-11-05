package org.emiliaargibayafonso.DAO;
import java.sql.Connection;

public interface InterfazDAO {
    void retrieveAll(Connection conexion);
    boolean insert();
    boolean update();
    boolean delete();
}
