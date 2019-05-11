package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.view.UserView;

import java.util.List;

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
    List<UserView> users(UserView user);

    /**
     * Есть ли человек в БД
     *
     */
    boolean isUserExist(UserView user);

    /**
     * Найти человека в БД и вернуть его данные
     * @return {@User}
     */
    UserView find(Long id);

    /**
     * Добавить человека в БД
     *
     */
    void add(UserView user);

    /**
     * Обновить человека в БД
     *
     */
    void update(UserView user);

    /**
     * Удалить человека в БД
     *
     */
    void delete(Long id);




}
