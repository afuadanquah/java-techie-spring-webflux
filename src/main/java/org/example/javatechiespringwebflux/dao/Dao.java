package org.example.javatechiespringwebflux.dao;

import reactor.core.publisher.Flux;

import java.util.List;

public interface Dao<T> {

    public List<T> getAll();


    public Flux<T> getAllFlux();
}
