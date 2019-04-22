package ru.mithril.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.daoInterface.OfficeDaoJdbcTemplateImpl;
import ru.mithril.demo.model.mapper.MapperFacade;
import ru.mithril.demo.model.user.service.Office;
import ru.mithril.demo.service.serviceInterface.OfficeService;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDaoJdbcTemplateImpl dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(MapperFacade mapperFacade) {
        this.dao = new OfficeDaoJdbcTemplateImpl();
        this.mapperFacade = mapperFacade;
    }



    @Override
    @Transactional(readOnly = true)
    public List<Office> offices() {
        List<Office> all = dao.offices();
        return mapperFacade.mapAsList(all, Office.class);
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
