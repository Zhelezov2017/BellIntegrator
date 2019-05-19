package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.view.OfficeView;

import java.util.List;

@Validated
public interface OfficeService  {

    /**
     * Получить список офисов
     *
     * @return {@Office}
     */
    List<OfficeView> offices(OfficeView office);

    /**
     * Есть ли офис в БД
     *
     */
    boolean isOfficeExist(OfficeView office);

    /**
     * Найти офис в БД и вернуть его данные
     * @return {@User}
     */
    OfficeView find(Long id);

    /**
     * Добавить офис в БД
     *
     */
    void add(OfficeView office);

    /**
     * Обновить офис в БД
     *
     */
    void update(OfficeView office);

    /**
     * Удалить офис из БД
     *
     */
    void delete(Long id);
}
