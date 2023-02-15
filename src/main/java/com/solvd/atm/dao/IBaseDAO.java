package com.solvd.atm.dao;

public interface IBaseDAO<T> {
    T getEntityById(long id);

    boolean updateEntity(T entity);

    T createEntity(T entity);

    boolean removeEntity(long id);
}
