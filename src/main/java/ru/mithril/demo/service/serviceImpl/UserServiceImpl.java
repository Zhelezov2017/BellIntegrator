package ru.mithril.demo.service.serviceImpl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.daoInterface.UsersDaoJdbcTemplateImpl;
import ru.mithril.demo.model.user.service.User;
import ru.mithril.demo.model.mapper.MapperFacade;
import ru.mithril.demo.service.serviceInterface.UserService;

import java.util.*;

@Service
@Repository
public class UserServiceImpl implements UserService {


    private final MapperFacade mapperFacade;
    public static Map<Long, User> users = new HashMap<>();

    @Autowired
    public UserServiceImpl(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }
    static {
        initUsers();
    }

    private static void initUsers() {
        User userVlad = new User(new Long("1"), "Vlad", "Igorevich", "Zhelezov", "Meneger", "89549613229", "1", "1", new Long("0"));
        User userAnton = new User(new Long("2"), "Anton", "Sergeevich", "Makarev", "Ingener", "89349212225", "1", "2", new Long("0"));
        User userSergey = new User(new Long("3"), "Sergey", "Vladimirovich", "Bontor", "Director", "89999713479", "1", "3", new Long("0"));

        users.put(userVlad.id, userVlad);
        users.put(userAnton.id, userAnton);
        users.put(userSergey.id, userSergey);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> users(){
        Collection<User> col = users.values();
        List<User> list = new ArrayList<>();
        list.addAll(col);
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> find(Long id) {
        return Optional.of(users.get(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> add(User user) {
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> update(User user) {
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        users.remove(id);
    }




}
