package com.gmail.supersonicleader.mvc.repository;

import java.util.List;

public interface GenericRepository<I, T> {

    List<T> getObjectsByPage(int startPosition, int maxResult);

    List<T> findAll();

    T findById(I id);

    void add(T entity);

    void delete(T entity);

}
