package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.model.User;
import ru.mithril.demo.view.UserView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Сервис пользователей
 */
@Validated
public interface UserService  {

    /**
     * Получить список людей
     *
     * @return {@User}
     */
    List<UserView> users();

    Optional<User> find(Long id);
    void add(@Valid UserView user);
    void update(@Valid UserView user);

    void delete(Long id);




}
