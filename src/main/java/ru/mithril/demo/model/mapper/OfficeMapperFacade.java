package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import ru.mithril.demo.model.Office;
import ru.mithril.demo.view.OfficeView;

import java.util.Collection;
import java.util.List;

@Service
public class OfficeMapperFacade implements MapperFacadeInterface<Office, OfficeView> {

    private final MapperFacade mapperFacade;

    public OfficeMapperFacade(MapperFactory mapperFactory) {
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Office mapToEntity(OfficeView view) {
        return mapperFacade.map(view, Office.class);
    }

    @Override
    public OfficeView map(Office entity) {
        return mapperFacade.map(entity, OfficeView.class);
    }

    @Override
    public List<Office> mapAsListEntity(Collection<OfficeView> views) {
        return mapperFacade.mapAsList(views, Office.class);
    }

    @Override
    public List<OfficeView> mapAsListView(Collection<Office> views) {
        return mapperFacade.mapAsList(views, OfficeView.class);
    }
}
