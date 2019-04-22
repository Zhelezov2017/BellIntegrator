package ru.mithril.demo.dao.daoInterface;

import java.util.Optional;

public interface CrudDAO<T> {

    Optional<T> find(Long id);
    Optional<T> add(T model);
    Optional<T> update(T model);
    void delete(Long id);

}
