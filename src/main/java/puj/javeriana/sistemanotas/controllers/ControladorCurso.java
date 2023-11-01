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

import puj.javeriana.sistemanotas.models.Curso;
import puj.javeriana.sistemanotas.repositories.RepositorioCurso;
import puj.javeriana.sistemanotas.repositories.RepositorioCursoProfesor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cursos")
public class ControladorCurso {
    @Autowired
    private RepositorioCurso repositorioCurso;

    @Autowired
    private RepositorioCursoProfesor repositorioCursoProfesor;

    @GetMapping("/")
    public Flux<Curso> getCursos(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return repositorioCurso
                .findAll()
                .skip((page - 1) * limit)
                .take(limit);
    }

    @GetMapping("/{id}")
    public Mono<Curso> getCurso(@PathVariable Integer id) {
        return repositorioCurso.findById(id);
    }

    @PostMapping("/")
    public Mono<Curso> postCurso(@RequestBody Curso curso) {
        return repositorioCurso
                .save(curso)
                .flatMap(cursoGuardado -> repositorioCursoProfesor
                        .createByCurso(cursoGuardado)
                        .thenReturn(cursoGuardado));
    }

    @PatchMapping("/{id}")
    public Mono<Curso> patchCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        return repositorioCurso
                .findAndUpdate(id, curso)
                .flatMap(cursoGuardado -> repositorioCursoProfesor
                        .updateByCurso(cursoGuardado)
                        .thenReturn(cursoGuardado));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCurso(@PathVariable Integer id) {
        return repositorioCurso
                .findById(id)
                .flatMap(curso -> repositorioCursoProfesor
                        .deleteByCurso(curso)
                        .thenReturn(curso))
                .flatMap(curso -> repositorioCurso.deleteById(curso.getId()));
    }
}
