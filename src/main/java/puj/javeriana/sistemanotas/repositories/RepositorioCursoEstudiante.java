package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.CursoEstudiante;

public interface RepositorioCursoEstudiante extends ReactiveCrudRepository<CursoEstudiante, Integer> {

}
