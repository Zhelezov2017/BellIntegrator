package ru.mithril.demo.dao.daoInterface;

public interface CrudDAO<T> {

    T find(Long id);
    void add(T model);
    void update(T model);
    void delete(Long id);

}
