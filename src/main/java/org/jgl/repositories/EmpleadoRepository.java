package org.jgl.repositories;

import org.jgl.entities.Cliente;
import org.jgl.entities.Empleado;
import org.jgl.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getConnection();
    }

    /**
     Método para mostrar la lista de empleados con la consulta "SELECT * FROM empleado"
     */
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(rs.getInt("codigo_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setExtension(rs.getString("extension"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPuesto(rs.getString("puesto"));

                // Manejo de valores que pueden ser nulos
                String codigoOficina = rs.getString("codigo_oficina");
                if (rs.wasNull()) {
                    empleado.setCodigoOficina(null);
                } else {
                    empleado.setCodigoOficina(codigoOficina);
                }

                int codigoJefe = rs.getInt("codigo_jefe");
                if (rs.wasNull()) {
                    empleado.setCodigoJefe(null);
                } else {
                    empleado.setCodigoJefe(codigoJefe);
                }
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
