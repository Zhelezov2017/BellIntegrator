package ru.mithril.demo.dao.implementation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mithril.demo.dao.daoInterface.OrganizationDao;
import ru.mithril.demo.model.Organization;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Data
public class OrganizationDaoJdbcTemplateImpl implements OrganizationDao {

    private final EntityManager em;
    @Autowired
    public OrganizationDaoJdbcTemplateImpl(EntityManager em) {
        this.em = em;
    }

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
