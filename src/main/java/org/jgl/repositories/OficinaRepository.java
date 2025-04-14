package org.jgl.repositories;

import org.jgl.entities.Oficina;
import org.jgl.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OficinaRepository {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getConnection();
    }

    /**
     Método para mostrar la lista de oficinas con la consulta "SELECT * FROM oficina"
     */
    public List<Oficina> getOficinas() {
        List<Oficina> oficinas = new ArrayList<>();
        String sql = "SELECT * FROM oficina";

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Oficina oficina = new Oficina();
                oficina.setCodigoOficina(rs.getString("codigo_oficina"));
                oficina.setCiudad(rs.getString("ciudad"));
                oficina.setPais(rs.getString("pais"));
                oficina.setRegion(rs.getString("region"));
                oficina.setCodigoPostal(rs.getString("codigo_postal"));
                oficina.setTelefono(rs.getString("telefono"));
                oficina.setLineaDireccion1(rs.getString("linea_direccion1"));
                oficina.setLineaDireccion2(rs.getString("linea_direccion2"));
                oficinas.add(oficina);
            }
            return oficinas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
