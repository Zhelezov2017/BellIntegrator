package ru.mithril.demo.service.serviceInterface;


import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.view.DocumentView;

import java.util.List;

/**
 * Сервис документов
 */
@Validated
public interface DocumentService {

    List<DocumentView> doc(DocumentView officeView);
}
