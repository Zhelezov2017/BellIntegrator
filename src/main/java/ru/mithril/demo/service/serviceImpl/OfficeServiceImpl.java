package ru.mithril.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.implementation.OfficeDaoJdbcTemplateImpl;
import ru.mithril.demo.model.mapper.MapperFacadeInterface;
import ru.mithril.demo.model.user.service.Office;
import ru.mithril.demo.service.serviceInterface.OfficeService;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDaoJdbcTemplateImpl dao;
    private final MapperFacadeInterface mapperFacadeInterface;

    @Autowired
    public OfficeServiceImpl(MapperFacadeInterface mapperFacadeInterface) {
        this.dao = new OfficeDaoJdbcTemplateImpl();
        this.mapperFacadeInterface = mapperFacadeInterface;
    }


    @Override
    public List<Office> offices() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Office> find(Long id) {
        return dao.find(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Office> add(Office office) {
        return dao.add(office);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Office> update(Office office) {
        return dao.update(office);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        dao.delete(id);
    }


}
