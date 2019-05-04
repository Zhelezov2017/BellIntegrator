package ru.mithril.demo.dao.daoInterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mithril.demo.model.user.service.User;
import ru.mithril.demo.service.serviceInterface.UserService;

import java.util.*;

@Data
@AllArgsConstructor
public class UsersDaoJdbcTemplateImpl implements UserService {



    private static final Map<Long, User> users = new HashMap<>();


    @Override
    public List<User> users(){
        Collection<User> col = users.values();
        List<User> list = new ArrayList<>();
        list.addAll(col);
        return list;
    }

    @Override
    public Optional<User> find(Long id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Optional<User> add(User user) {
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> update(User user) {
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
    }


}
