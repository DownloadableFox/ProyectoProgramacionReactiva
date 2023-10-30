package puj.javeriana.sistemanotas.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import puj.javeriana.sistemanotas.models.Persona;

public interface RepositorioPersona extends ReactiveCrudRepository<Persona, Integer> {}
