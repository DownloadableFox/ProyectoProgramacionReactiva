package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Materia;
import reactor.core.publisher.Mono;

public interface RepositorioMateria extends ReactiveCrudRepository<Materia, Integer> {
    public default Mono<Materia> findAndUpdate(Integer id, Materia actualizada) {
        return this
                .findById(id)
                .flatMap(materia -> {
                    if (actualizada.getNombre() != null) {
                        materia.setNombre(actualizada.getNombre());
                    }

                    if (actualizada.getCreditos() != null) {
                        materia.setCreditos(actualizada.getCreditos());
                    }

                    return this.save(materia);
                });
    }
}