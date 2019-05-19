package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.view.OrganizationView;

import java.util.List;

/**
 * Сервис организациии
 */
@Validated
public interface OrganizationService {

    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */
    List<OrganizationView> organizations(OrganizationView organization);

    /**
     * Есть ли организация в БД
     *
     */
    boolean isOfficeExist(OrganizationView organization);

    /**
     * Найти организацию в БД и вернуть ее данные
     * @return {@User}
     */
    OrganizationView find(Long id);

    /**
     * Добавить организацию в БД
     *
     */
    void add(OrganizationView organization);

    /**
     * Обновить организацию в БД
     *
     */
    void update(OrganizationView organization);

    /**
     * Удалить организацию из БД
     *
     */
    void delete(Long id);

}
