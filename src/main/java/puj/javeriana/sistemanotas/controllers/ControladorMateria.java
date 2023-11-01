package puj.javeriana.sistemanotas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import puj.javeriana.sistemanotas.models.Materia;
import puj.javeriana.sistemanotas.repositories.RepositorioMateria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/materias")
public class ControladorMateria {
    @Autowired
    private RepositorioMateria repositorioMateria;

    @GetMapping("/")
    public Flux<Materia> getMaterias(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return repositorioMateria
                .findAll()
                .skip((page - 1) * limit)
                .take(limit);
    }

    @GetMapping("/{id}")
    public Mono<Materia> getMateria(@PathVariable Integer id) {
        return repositorioMateria.findById(id);
    }

    @PostMapping("/")
    public Mono<Materia> postMateria(@RequestBody Materia materia) {
        return repositorioMateria.save(materia);
    }

    @PatchMapping("/{id}")
    public Mono<Materia> patchMateria(@PathVariable Integer id, @RequestBody Materia materia) {
        return repositorioMateria.findAndUpdate(id, materia);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMateria(@PathVariable Integer id) {
        return repositorioMateria.deleteById(id);
    }

}
