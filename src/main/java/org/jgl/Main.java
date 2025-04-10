package org.jgl;

import org.jgl.repositories.ClienteRepository;
import org.jgl.util.ConexionBD;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.getClientes().forEach(System.out::println);
    }
}
