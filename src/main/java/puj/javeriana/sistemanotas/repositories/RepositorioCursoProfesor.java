package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Curso;
import puj.javeriana.sistemanotas.models.CursoProfesor;
import reactor.core.publisher.Mono;

public interface RepositorioCursoProfesor extends ReactiveCrudRepository<CursoProfesor, Integer> {
    public default Mono<CursoProfesor> createByCurso(Curso curso) {
        return this.save(new CursoProfesor(null, curso.getId(), curso.getProfesorId()));
    }

    public default Mono<CursoProfesor> updateByCurso(Curso curso) {
        return this.findByCursoId(curso.getId())
                .flatMap(cursoProfesor -> {
                    cursoProfesor.setProfesorId(curso.getProfesorId());

                    return this.save(cursoProfesor);
                });
    }

    public default Mono<Void> deleteByCurso(Curso curso) {
        return this.deleteAll(this.findByCursoId(curso.getId()));
    }

    public Mono<CursoProfesor> findByCursoId(Integer cursoId);
}
