package puj.javeriana.sistemanotas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Persona {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;

    private Character rol;
}

