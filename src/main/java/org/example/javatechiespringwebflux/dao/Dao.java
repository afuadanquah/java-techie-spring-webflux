package org.example.javatechiespringwebflux.dao;

import java.util.List;

public interface Dao<T> {

    public List<T> getAll();

}
