package puj.javeriana.sistemanotas.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Curso {
    @Id
    private Integer id;
    private String numero;

    @Column("materia_id")
    @JsonProperty("materia_id")
    private Integer materiaId;

    @Column("profesor_id")
    @JsonProperty("profesor_id")
    private Integer profesorId;

    @Column("fecha_inicio")
    @JsonProperty("fecha_inicio")
    private Integer fechaInicio;

    @Column("fecha_fin")
    @JsonProperty("fecha_fin")
    private Integer fechaFin;

    // @Transient
    // private Materia materia;

    // @Transient
    // private Persona profesor;
}
