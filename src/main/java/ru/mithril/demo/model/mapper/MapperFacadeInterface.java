package ru.mithril.demo.model.mapper;

import java.util.Collection;
import java.util.List;

public interface MapperFacadeInterface<S,D> {
    /**
     * Преобразование объекта D в экземпляр класса S
     */
     S mapToEntity(D view);
    /**
     * Преобразование объекта S в экземпляр класса D
     */
     D map(S entity);

    /**
     * Преобразование коллекции D в коллекцию S
     */
     List<S> mapAsListEntity(Collection<D> views);

    /**
     * Преобразование коллекции S в коллекцию D
     */
     List<D> mapAsListView(Collection<S> views);
}
