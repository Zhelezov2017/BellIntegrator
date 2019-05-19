package ru.mithril.demo.dao.implementation;

import ru.mithril.demo.dao.daoInterface.OrganizationDao;
import ru.mithril.demo.model.Organization;

import java.util.List;

public class OrganizationDaoJdbcTemplateImpl implements OrganizationDao {


    @Override
    public List<Organization> organization(Organization organization) {
        return null;
    }

    @Override
    public Organization find(Long id) {
        return null;
    }

    @Override
    public void add(Organization model) {

    }

    @Override
    public void update(Organization model) {

    }

    @Override
    public void delete(Long id) {

    }
}
