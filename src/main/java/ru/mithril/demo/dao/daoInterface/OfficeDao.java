package ru.mithril.demo.dao.daoInterface;

import ru.mithril.demo.model.Office;

import java.util.List;

public interface OfficeDao extends CrudDAO<Office> {
    List<Office> office(Office office);
}
