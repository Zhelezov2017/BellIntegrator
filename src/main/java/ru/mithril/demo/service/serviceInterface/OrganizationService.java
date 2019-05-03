package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.model.Organization;

import java.util.List;
import java.util.Optional;

/**
 * Сервис организациии
 */
@Validated
public interface OrganizationService {

    List<Organization> organizations();

    Optional<Organization> find(Long id);
    Optional<Organization> add(Organization organization);
    Optional<Organization> update(Organization organization);

    void delete(Long id);

}
