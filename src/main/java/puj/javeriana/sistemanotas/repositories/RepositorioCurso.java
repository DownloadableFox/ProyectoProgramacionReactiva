package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Curso;
import reactor.core.publisher.Mono;

public interface RepositorioCurso extends ReactiveCrudRepository<Curso, Integer> {
    public default Mono<Curso> findAndUpdate(Integer id, Curso actualizado) {
        return this.findById(id)
                .flatMap(curso -> {
                    if (actualizado.getNumero() != null) {
                        curso.setNumero(actualizado.getNumero());
                    }

                    if (actualizado.getMateriaId() != null) {
                        curso.setMateriaId(actualizado.getMateriaId());
                    }

                    if (actualizado.getProfesorId() != null) {
                        curso.setProfesorId(actualizado.getProfesorId());
                    }

                    if (actualizado.getFechaInicio() != null) {
                        curso.setFechaInicio(actualizado.getFechaInicio());
                    }

                    if (actualizado.getFechaFin() != null) {
                        curso.setFechaFin(actualizado.getFechaFin());
                    }

                    return this.save(curso);
                });
    }
}
