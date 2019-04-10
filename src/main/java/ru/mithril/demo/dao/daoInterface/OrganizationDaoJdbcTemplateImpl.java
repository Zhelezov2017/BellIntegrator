package ru.mithril.demo.service.serviceInterface;

import ru.mithril.demo.dao.daoInterface.CrudDAO;

import java.util.List;
import java.util.Optional;


public class OrganizationDaoJdbcTemplateImpl implements CrudDAO {



    @Override
    public Optional find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
