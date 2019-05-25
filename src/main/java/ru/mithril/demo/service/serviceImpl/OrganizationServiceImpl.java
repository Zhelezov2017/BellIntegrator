package ru.mithril.demo.service.serviceImpl;

import org.springframework.stereotype.Service;
import ru.mithril.demo.service.serviceInterface.OrganizationService;
import ru.mithril.demo.view.OrganizationView;

import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Override
    public List<OrganizationView> organizations(OrganizationView organization) {
        return null;
    }

    @Override
    public boolean isOfficeExist(OrganizationView organization) {
        return false;
    }

    @Override
    public OrganizationView find(Long id) {
        return null;
    }

    @Override
    public void add(OrganizationView organization) {

    }

    @Override
    public void update(OrganizationView organization) {

    }

    @Override
    public void delete(Long id) {

    }
}
