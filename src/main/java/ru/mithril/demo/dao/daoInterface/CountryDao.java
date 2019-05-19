package ru.mithril.demo.dao.daoInterface;

import ru.mithril.demo.model.Country;

import java.util.List;

public interface CountryDao {

    List<Country> country(Country country);
}
