package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.model.user.service.User;

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
    List<User> users();

    Optional<User> find(Long id);
    Optional<User> add(User user);
    Optional<User> update(User user);

    void delete(Long id);




}
