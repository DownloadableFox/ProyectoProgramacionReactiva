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
public class CursoProfesor {
    public CursoProfesor() {
    }

    @Id
    private Integer id;
    private Integer cursoId;

    @Column("profesor_id")
    @JsonProperty("profesor_id")
    private Integer profesorId;
}
