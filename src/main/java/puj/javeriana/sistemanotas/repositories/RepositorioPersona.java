package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Persona;
import reactor.core.publisher.Mono;

public interface RepositorioPersona extends ReactiveCrudRepository<Persona, Integer> {
    public default Mono<Persona> findAndUpdate(Integer id, Persona actualizada) {
        return this
            .findById(id)
            .flatMap(persona -> {
                if (actualizada.getNombre() != null) {
                    persona.setNombre(actualizada.getNombre());
                }

                if (actualizada.getApellido() != null) {
                    persona.setApellido(actualizada.getApellido());
                }

                if (actualizada.getCorreo() != null) {
                    persona.setCorreo(actualizada.getCorreo());
                }

                if (actualizada.getRol() != null) {
                    persona.setRol(actualizada.getRol());
                }

                return this.save(persona);
            });
    }
}
