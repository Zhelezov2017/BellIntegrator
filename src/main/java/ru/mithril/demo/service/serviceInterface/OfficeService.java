package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.model.user.service.Office;

import java.util.List;
import java.util.Optional;

@Validated
public interface OfficeService  {

    List<Office> offices();

    Optional<Office> find(Long id);
    Optional<Office> add(Office office);
    Optional<Office> update(Office office);

    void delete(Long id);
}
