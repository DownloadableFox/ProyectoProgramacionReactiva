package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Nota;
import reactor.core.publisher.Mono;

public interface RepositorioNota extends ReactiveCrudRepository<Nota, Integer> {
    public default Mono<Nota> findAndUpdate(Integer id, Nota actualizda) {
        return this.findById(id)
                .flatMap(nota -> {
                    if (actualizda.getCursoId() != null) {
                        nota.setCursoId(actualizda.getCursoId());
                    }

                    if (actualizda.getEstudianteId() != null) {
                        nota.setEstudianteId(actualizda.getEstudianteId());
                    }

                    if (actualizda.getObservacion() != null) {
                        nota.setObservacion(actualizda.getObservacion());
                    }

                    if (actualizda.getValor() != null) {
                        nota.setValor(actualizda.getValor());
                    }

                    return this.save(nota);
                });
    }
}