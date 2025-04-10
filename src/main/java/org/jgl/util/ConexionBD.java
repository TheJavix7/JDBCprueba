package org.jgl.util;

import java.sql.*;

public class ConexionBD {

    private static final String url = "jdbc:mysql://localhost:3306/jardineria";
    private static final String user = "root";
    private static final String clave = "password";

    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(url, user, clave);
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
