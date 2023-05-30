package com.geektrust.backend.Repositories;

import java.util.List;


public interface CRUDRepository<T,ID> {
    public List<T> findAll();
    public T findById(ID id);
    boolean existsById(ID id) ;
    
}