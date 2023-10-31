package puj.javeriana.sistemanotas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.javeriana.sistemanotas.models.Curso;
import puj.javeriana.sistemanotas.repositories.RepositorioCurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cursos")
public class ControladorCurso {
    @Autowired
    private RepositorioCurso repositorioCurso;

    @GetMapping("/")
    public Flux<Curso> getCursos() {
        return repositorioCurso.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Curso> getCurso(Integer id) {
        return repositorioCurso.findById(id);
    }

    @PostMapping("/")
    public Mono<Curso> postCurso(@RequestBody Curso curso) {
        return repositorioCurso.save(curso);
    }

    @PatchMapping("/{id}")
    public Mono<Curso> patchCurso(Integer id, @RequestBody Curso curso) {
        return repositorioCurso.findAndUpdate(id, curso);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCurso(Integer id) {
        return repositorioCurso.deleteById(id);
    }
}
