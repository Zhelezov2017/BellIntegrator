package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import ru.mithril.demo.model.Organization;
import ru.mithril.demo.view.OrganizationView;

import java.util.Collection;
import java.util.List;

@Service
public class OrganizationMapperFacade implements MapperFacadeInterface<Organization, OrganizationView>{

    private final MapperFacade mapperFacade;

    public OrganizationMapperFacade(MapperFactory mapperFactory) {
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Organization mapToEntity(OrganizationView view) {
        return mapperFacade.map(view, Organization.class);
    }

    @Override
    public OrganizationView map(Organization entity) {
        return mapperFacade.map(entity, OrganizationView.class);
    }

    @Override
    public List<Organization> mapAsListEntity(Collection<OrganizationView> views) {
        return mapperFacade.mapAsList(views, Organization.class);
    }

    @Override
    public List<OrganizationView> mapAsListView(Collection<Organization> views) {
        return mapperFacade.mapAsList(views, OrganizationView.class);
    }
}
