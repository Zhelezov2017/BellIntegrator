package ru.mithril.demo.dao.implementation;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.mithril.demo.dao.daoInterface.DocumentDao;
import ru.mithril.demo.model.Doc;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Data
public class DocumentDaoJdbcTemplateImpl implements DocumentDao {
    private final EntityManager em;

    public DocumentDaoJdbcTemplateImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Doc> doc(Doc doc) {
        return null;
    }
}
