package ru.mithril.demo.model.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import ru.mithril.demo.model.User;
import ru.mithril.demo.view.UserView;

import java.util.Collection;
import java.util.List;

@Service
public class UserMapperFacade implements MapperFacadeInterface<User,UserView> {

    private final MapperFacade mapperFacade;

    public UserMapperFacade(MapperFactory mapperFactory) {
        mapperFacade = mapperFactory.getMapperFacade();
    }


    @Override
    public User mapToEntity(UserView view) {
        return mapperFacade.map(view, User.class);
    }

    @Override
    public UserView map(User entity) {
        return mapperFacade.map(entity, UserView.class);
    }

    @Override
    public List<User> mapAsListEntity(Collection<UserView> views) {
        return mapperFacade.mapAsList(views, User.class);
    }

    @Override
    public List<UserView> mapAsListView(Collection<User> views) {
        return mapperFacade.mapAsList(views, UserView.class);
    }
}
