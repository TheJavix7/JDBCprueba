package org.jgl.repositories;

import org.jgl.entities.Cliente;
import org.jgl.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getConnection();
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try(Statement stmt = getConnection().createStatement();){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigo_cliente"));
                cliente.setNombreCliente(rs.getString("nombre_cliente"));
                cliente.setNombreContacto(rs.getString("nombre_contacto"));
                cliente.setApellidoContacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLineaDireccion1(rs.getString("linea_direccion1"));
                cliente.setLineaDireccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));

                // Manejo de valores que pueden ser nulos
                int repVentas = rs.getInt("rep_ventas");
                if (rs.wasNull()) {
                    cliente.setRepVentas(null);
                } else {
                    cliente.setRepVentas(repVentas);
                }

                float limiteCredito = rs.getFloat("limite_credito");
                if (rs.wasNull()) {
                    cliente.setLimiteCredito(null);
                } else {
                    cliente.setLimiteCredito(limiteCredito);
                }
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
