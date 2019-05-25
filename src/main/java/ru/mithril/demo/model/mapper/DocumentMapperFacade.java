package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import ru.mithril.demo.model.Doc;
import ru.mithril.demo.view.DocumentView;

import java.util.Collection;
import java.util.List;

@Service
public class DocumentMapperFacade implements MapperFacadeInterface<Doc,DocumentView> {

    private final MapperFacade mapperFacade;

    public DocumentMapperFacade(MapperFactory mapperFactory) {
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Doc mapToEntity(DocumentView view) {
        return mapperFacade.map(view, Doc.class);
    }

    @Override
    public DocumentView map(Doc entity) {
        return mapperFacade.map(entity, DocumentView.class);
    }

    @Override
    public List<Doc> mapAsListEntity(Collection<DocumentView> views) {
        return mapperFacade.mapAsList(views, Doc.class);
    }

    @Override
    public List<DocumentView> mapAsListView(Collection<Doc> views) {
        return mapperFacade.mapAsList(views, DocumentView.class);
    }
}
