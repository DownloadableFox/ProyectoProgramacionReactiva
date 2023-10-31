package puj.javeriana.sistemanotas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.javeriana.sistemanotas.models.Nota;
import puj.javeriana.sistemanotas.repositories.RepositorioNota;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/notas")
public class ControladorNota {
    @Autowired
    private RepositorioNota repositorioNota;

    @GetMapping("/")
    public Flux<Nota> getNotas() {
        return repositorioNota.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Nota> getNota(@PathVariable Integer id) {
        return repositorioNota.findById(id);
    }

    @PostMapping("/")
    public Mono<Nota> postNota(@RequestBody Nota nota) {
        return repositorioNota.save(nota);
    }

    @PatchMapping("/{id}")
    public Mono<Nota> patchNota(@PathVariable Integer id, @RequestBody Nota nota) {
        return repositorioNota.findAndUpdate(id, nota);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteNota(@PathVariable Integer id) {
        return repositorioNota.deleteById(id);
    }
}
