package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import ru.mithril.demo.model.Country;
import ru.mithril.demo.view.CountryView;

import java.util.Collection;
import java.util.List;

@Service
public class CountryMapperFacade implements MapperFacadeInterface<Country,CountryView> {

    private final MapperFacade mapperFacade;

    public CountryMapperFacade(MapperFactory mapperFactory) {
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Country mapToEntity(CountryView view) {
        return mapperFacade.map(view, Country.class);
    }

    @Override
    public CountryView map(Country entity) {
        return mapperFacade.map(entity, CountryView.class);
    }

    @Override
    public List<Country> mapAsListEntity(Collection<CountryView> views) {
        return mapperFacade.mapAsList(views, Country.class);
    }

    @Override
    public List<CountryView> mapAsListView(Collection<Country> views) {
        return mapperFacade.mapAsList(views, CountryView.class);
    }
}
