package puj.javeriana.sistemanotas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import puj.javeriana.sistemanotas.models.Persona;
import puj.javeriana.sistemanotas.repositories.RepositorioPersona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ControladorPersona {
    @Autowired
    private RepositorioPersona repositorioPersona;

    @GetMapping("/api/personas")
    public Flux<Persona> getPersonas() {
        return repositorioPersona.findAll();
    }

    @GetMapping("/api/personas/{id}")
    public Mono<Persona> getPersona(@PathVariable Integer id) {
        return repositorioPersona.findById(id);
    }

    @PostMapping("/api/personas")
    public Mono<Persona> postPersona(@RequestBody Persona persona) {
        return repositorioPersona.save(persona);
    }

    @PatchMapping("/api/personas/{id}")
    public Mono<Persona> patchPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        return repositorioPersona.findAndUpdate(id, persona);
    }

    @DeleteMapping("/api/personas/{id}")
    public Mono<Void> deletePersona(@PathVariable Integer id) {
        return repositorioPersona.deleteById(id);
    }

}
