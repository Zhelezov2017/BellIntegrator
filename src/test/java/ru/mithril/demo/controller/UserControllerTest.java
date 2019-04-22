package ru.mithril.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mithril.demo.model.user.service.User;
import ru.mithril.demo.service.serviceImpl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserControllerTest {


    @MockBean
    public UserController userController;

    @Test
    public void setUser() {
        User user = new User(new Long("4"),"Vlad", "Firsten");
        userController.setUser(user);
    }

    @Test
    public void getUsers() {
        User user = new User(new Long("4"),"Vlad", "Firsten");
        userController.getUsers();
    }

    @Test
    public void getUser() {
        userController.getUser(new Long("3"));
    }

    @Test
    public void updateUser() {
        User user = UserServiceImpl.users.get(new Long("2"));
        userController.updateUser(user,new Long("3"));
        userController.deleteUser(new Long("3"));
    }

    @Test
    public void deleteUser() {
        userController.deleteUser(new Long("3"));
    }
}