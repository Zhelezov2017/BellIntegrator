package ru.mithril.demo.dao.implementation;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.mithril.demo.dao.daoInterface.CountryDao;
import ru.mithril.demo.model.Country;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Data
public class CountryDaoJdbcTemplateImpl implements CountryDao {

    private final EntityManager em;

    public CountryDaoJdbcTemplateImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Country> country(Country country) {
        return null;
    }
}
