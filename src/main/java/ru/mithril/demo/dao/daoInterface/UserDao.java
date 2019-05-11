package ru.mithril.demo.dao.daoInterface;

import ru.mithril.demo.model.User;

import java.util.List;

public interface UserDao  extends CrudDAO<User>{

    List<User> users(User user);
}
