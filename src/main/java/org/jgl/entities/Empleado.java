package org.jgl.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {
    private int codigoEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private String codigoOficina;
    private Integer codigoJefe;
    private String puesto;
}
