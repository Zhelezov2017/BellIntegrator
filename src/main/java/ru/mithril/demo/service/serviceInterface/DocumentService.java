package ru.mithril.demo.service.serviceInterface;


import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.model.Doc;

import java.util.List;

/**
 * Сервис документов
 */
@Validated
public interface DocumentService {

    List<Doc> doc();
}
