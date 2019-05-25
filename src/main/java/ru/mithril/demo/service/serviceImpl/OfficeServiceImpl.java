package ru.mithril.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mithril.demo.dao.daoInterface.OfficeDao;
import ru.mithril.demo.model.Office;
import ru.mithril.demo.model.mapper.OfficeMapperFacade;
import ru.mithril.demo.service.serviceInterface.OfficeService;
import ru.mithril.demo.view.OfficeView;

import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OfficeMapperFacade officeMapperFacade;


    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OfficeMapperFacade officeMapperFacade) {
        this.officeMapperFacade = officeMapperFacade;
        this.officeDao = officeDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices(OfficeView officeView) {
        Office office = officeMapperFacade.mapToEntity(officeView);
        List<Office> offices = officeDao.office(office);
        return officeMapperFacade.mapAsListView(offices);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isOfficeExist(OfficeView office) {
        return officeDao.find(office.getId())!=null;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView find(Long id) {
        Office office = officeDao.find(id);
        return officeMapperFacade.map(office);
    }

    @Override
    @Transactional(readOnly = true)
    public void add(OfficeView view) {
        Office office = officeMapperFacade.mapToEntity(view);
        officeDao.add(office);
    }

    @Override
    @Transactional(readOnly = true)
    public void update(OfficeView view) {
        Office office = officeMapperFacade.mapToEntity(view);
        officeDao.update(office);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        officeDao.delete(id);
    }
}
