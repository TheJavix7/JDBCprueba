package org.jgl;

import org.jgl.repositories.ClienteRepository;
import org.jgl.repositories.EmpleadoRepository;
import org.jgl.repositories.OficinaRepository;
import org.jgl.util.ConexionBD;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.getClientes().forEach(System.out::println);

        EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        empleadoRepository.getEmpleados().forEach(System.out::println);

        OficinaRepository oficinaRepository = new OficinaRepository();
        oficinaRepository.getOficinas().forEach(System.out::println);
    }
}
