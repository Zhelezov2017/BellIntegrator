package ru.mithril.demo.dao.daoInterface;

import ru.mithril.demo.model.Doc;

import java.util.List;

public interface DocumentDao {

    List<Doc> doc(Doc doc);
}
