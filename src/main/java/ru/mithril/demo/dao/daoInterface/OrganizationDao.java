package ru.mithril.demo.dao.daoInterface;

import ru.mithril.demo.model.Organization;

import java.util.List;

public interface OrganizationDao extends CrudDAO<Organization>{

    List<Organization> organization(Organization organization);
}
