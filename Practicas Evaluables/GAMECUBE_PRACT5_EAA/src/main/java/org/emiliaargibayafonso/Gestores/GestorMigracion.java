package org.emiliaargibayafonso.Gestores;
import java.sql.*;

public class GestorMigracion {
    public static void crearTablas(Connection gamecubeConn, Connection playConn) {
        try {
            DatabaseMetaData metaDatosGameCube = gamecubeConn.getMetaData();
            ResultSet tablasGameCube = metaDatosGameCube.getTables(null, null, "Juego_GameCube", null);
            String nombreBDGameCube = metaDatosGameCube.getDatabaseProductName(), nombreTablaGameCube = null;
            if (tablasGameCube.next()) {
                nombreTablaGameCube = tablasGameCube.getString("TABLE_NAME");
                System.out.println("Tabla de la BD "+nombreBDGameCube+": "+nombreTablaGameCube);
            } else {
                System.out.println("No se ha encontrado la tabla 'Juego_GameCube' en la base de datos.");
                return;
            }
            ResultSet columnasGameCube = metaDatosGameCube.getColumns(null, null, nombreTablaGameCube, null);

            StringBuilder queryCreateTable = new StringBuilder("CREATE TABLE Juego_PlayStation2 (");
            boolean primeraLinea = true; //Este boolean sirve para poder poner comas de manera más automatizada.
            while (columnasGameCube.next()) {
                if (!primeraLinea) queryCreateTable.append(", ");
                primeraLinea = false;
                String columnaNombre = columnasGameCube.getString("COLUMN_NAME");
                String columnaTipo = columnasGameCube.getString("TYPE_NAME");

                queryCreateTable.append(columnaNombre).append(" ").append(columnaTipo);
            }
            queryCreateTable.append(");");

            Statement stmt = playConn.createStatement();
            stmt.execute(queryCreateTable.toString());
            stmt.close();
        } catch (SQLException e) {
            System.out.println("ERROR (CrearTablas) ==> "+e.getMessage());
        }
    }
    public static void pasarDatos(Connection gamecubeConn, Connection playConn) {
        try {
            DatabaseMetaData metaDatosGameCube = gamecubeConn.getMetaData();
            ResultSet tablasGameCube = metaDatosGameCube.getTables(null, null, "%", new String[]{"TABLE"});

            while (tablasGameCube.next()) {
                String nomTablaGC = tablasGameCube.getString("TABLE_NAME");
                String nomTablaPlay = "Juego_PlayStation2";
                Statement stmt = gamecubeConn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM "+nomTablaGC);
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int nColumnas = rsMetaData.getColumnCount();

                //Según Gepeto lo de abajo crea tantos "?" como columnas haya en la tabla para añadir la información de cada columna.
                //(NOTA: Digo abiertamente que lo saqué de la IA porque no tenía idea de como hacer esto de manera automatizada.)
                StringBuilder queryInsertarDatos = new StringBuilder("INSERT INTO "+nomTablaPlay+" VALUES(");
                for (int i = 0; i < nColumnas; i++) {
                    if (i > 0) queryInsertarDatos.append(", ");
                    queryInsertarDatos.append("?");
                }
                queryInsertarDatos.append(")");

                //Lo de abajo básicamente crea un bucle que va preparando en el pdstmt cada columna (que son objetos).
                PreparedStatement pdstmt = playConn.prepareStatement(queryInsertarDatos.toString());
                while (rs.next()) {
                    for (int i = 1; i <= nColumnas; i++) {
                        pdstmt.setObject(i, rs.getObject(i)); //Gepeteada histórica, pa que mentir.
                    }
                    pdstmt.executeUpdate();
                }
                pdstmt.close();
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR (PasarTablas) ==> "+e.getMessage());
        }
    }
}