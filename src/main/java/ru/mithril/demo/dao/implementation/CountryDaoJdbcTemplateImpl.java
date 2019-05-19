package ru.mithril.demo.dao.implementation;

import ru.mithril.demo.dao.daoInterface.CountryDao;
import ru.mithril.demo.model.Country;

import java.util.List;

public class CountryDaoJdbcTemplateImpl implements CountryDao {

    @Override
    public List<Country> country(Country country) {
        return null;
    }
}
