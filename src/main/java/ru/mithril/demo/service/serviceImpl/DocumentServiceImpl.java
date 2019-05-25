package ru.mithril.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.daoInterface.DocumentDao;
import ru.mithril.demo.model.Doc;
import ru.mithril.demo.model.mapper.DocumentMapperFacade;
import ru.mithril.demo.service.serviceInterface.DocumentService;
import ru.mithril.demo.view.DocumentView;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final DocumentMapperFacade documentMapperFacade;

    @Autowired
    public DocumentServiceImpl(DocumentDao documentDao, DocumentMapperFacade documentMapperFacade) {
        this.documentMapperFacade = documentMapperFacade;
        this.documentDao = documentDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<DocumentView> doc(DocumentView documentView) {
        Doc doc = documentMapperFacade.mapToEntity(documentView);
        List<Doc> docs = documentDao.doc(doc);
        return documentMapperFacade.mapAsListView(docs);
    }

}
