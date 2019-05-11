package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class MapperFacadeImpl implements MapperFacadeInterface {

    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }


    @Override
    public Object mapToEntity(Object view) {
        return null;
    }

    @Override
    public Object map(Object entity) {
        return null;
    }

    @Override
    public List mapAsListEntity(Collection views) {
        return null;
    }

    @Override
    public List mapAsListView(Collection views) {
        return null;
    }
}
