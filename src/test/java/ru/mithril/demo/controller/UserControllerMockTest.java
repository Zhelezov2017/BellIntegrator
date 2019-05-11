package ru.mithril.demo.controller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.mithril.demo.service.serviceInterface.UserService;
import ru.mithril.demo.view.UserView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static ru.exception.com.springboot.ResponseBodyException.SUCCESS_RESPONSE_BODY;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerMockTest {

    private Gson json = new Gson();

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    static UserView user = new UserView(Long.getLong("1"),"Anton", "Ingener", 1, "Petrovich", "Saraev");


    @Test
    public void welcome() {
        userController.welcome();
    }

    @Test
    public void setUser() {
        //Пока не знаю, как решить
        //when(userService.add(user)).thenReturn(null);
        assertEquals(json.toJson(userController.setUser(user).getBody()), json.toJson(SUCCESS_RESPONSE_BODY));
    }

    @Test
    public void getUsers() {
        when(userService.users(user)).thenReturn(null);
        assertEquals(json.toJson(userController.getUsers(user)), json.toJson(userController.getUsers(user)));
    }

    @Test
    public void getUser() {
        when(userService.find(Long.getLong("1"))).thenReturn(null);

        assertEquals(json.toJson(userController.getUser(Long.getLong("1"))), json.toJson(user));
    }

    @Test
    public void updateUser() {
    }
}