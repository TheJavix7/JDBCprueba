package org.jgl;

import org.jgl.util.ConexionBD;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try (Connection con = ConexionBD.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cliente");){
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + " - " + rs.getString(2)
                        + " - " + rs.getString(3));

                System.out.println();

                System.out.println(rs.getString("codigo_cliente")
                        + " - " + rs.getString("nombre_cliente")
                        + " - " + rs.getString("nombre_contacto"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
