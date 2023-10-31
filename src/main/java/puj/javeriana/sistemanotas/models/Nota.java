package puj.javeriana.sistemanotas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Nota {
    @Id
    private Integer id;

    @Column("curso_id")
    @JsonProperty("curso_id")
    private Integer cursoId;

    @Column("estudiante_id")
    @JsonProperty("estudiante_id")
    private Integer estudianteId;

    private String observacion;
    private Double valor;
}
