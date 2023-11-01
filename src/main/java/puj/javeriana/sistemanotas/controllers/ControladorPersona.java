package puj.javeriana.sistemanotas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import puj.javeriana.sistemanotas.models.Persona;
import puj.javeriana.sistemanotas.repositories.RepositorioPersona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personas")
public class ControladorPersona {
    @Autowired
    private RepositorioPersona repositorioPersona;

    @GetMapping("/")
    public Flux<Persona> getPersonas(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return repositorioPersona
                .findAll()
                .skip((page - 1) * limit)
                .take(limit);
    }

    @GetMapping("/{id}")
    public Mono<Persona> getPersona(@PathVariable Integer id) {
        return repositorioPersona.findById(id);
    }

    @PostMapping("/")
    public Mono<Persona> postPersona(@RequestBody Persona persona) {
        return repositorioPersona.save(persona);
    }

    @PatchMapping("/{id}")
    public Mono<Persona> patchPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        return repositorioPersona.findAndUpdate(id, persona);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePersona(@PathVariable Integer id) {
        return repositorioPersona.deleteById(id);
    }
}
