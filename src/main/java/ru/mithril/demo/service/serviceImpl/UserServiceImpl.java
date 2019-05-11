package ru.mithril.demo.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.daoInterface.UserDao;
import ru.mithril.demo.model.User;
import ru.mithril.demo.model.mapper.UserMapperFacade;
import ru.mithril.demo.service.serviceInterface.UserService;
import ru.mithril.demo.view.UserView;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserMapperFacade userMapperFacade;


    @Autowired
    public UserServiceImpl(UserDao userDao, UserMapperFacade userMapperFacade) {
        this.userMapperFacade = userMapperFacade;
        this.userDao = userDao;
    }

    //static {
    //   initUsers();
    //}

    //private static void initUsers() {
        //User userVlad = new User(new Long("1"), "Vlad", "Igorevich", "Zhelezov", "Meneger", "89549613229", "1", "1", new Long("0"));
        //User userAnton = new User(new Long("2"), "Anton", "Sergeevich", "Makarev", "Ingener", "89349212225", "1", "2", new Long("0"));
        //User userSergey = new User(new Long("3"), "Sergey", "Vladimirovich", "Bontor", "Director", "89999713479", "1", "3", new Long("0"));

        //users.put(userVlad.id, userVlad);
        //users.put(userAnton.id, userAnton);
        //users.put(userSergey.id, userSergey);
    //}


    @Override
    @Transactional(readOnly = true)
    public List<UserView> users(UserView userView){
        User user = userMapperFacade.mapToEntity(userView);
        List<User> users = userDao.users(user);
        return userMapperFacade.mapAsListView(users);
    }

    @Override
    @Transactional(readOnly = true)
    public UserView find(Long id) {
        User user = userDao.find(id);
        return userMapperFacade.map(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void add(UserView view) {
        User user = userMapperFacade.mapToEntity(view);
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void update(UserView view) {
        User user = userMapperFacade.mapToEntity(view);
        userDao.update(user);
    }
    @Override
    @Transactional(readOnly = true)
    public boolean isUserExist(UserView user) {
        return userDao.find(user.getId())!=null;
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        userDao.delete(id);
    }




}
