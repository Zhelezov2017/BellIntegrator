package ru.mithril.demo.service.serviceImpl;

import ru.mithril.demo.service.serviceInterface.OfficeService;
import ru.mithril.demo.view.OfficeView;

import java.util.List;

public class OfficeServiceImpl implements OfficeService {
    @Override
    public List<OfficeView> offices(OfficeView office) {
        return null;
    }

    @Override
    public boolean isOfficeExist(OfficeView office) {
        return false;
    }

    @Override
    public OfficeView find(Long id) {
        return null;
    }

    @Override
    public void add(OfficeView office) {

    }

    @Override
    public void update(OfficeView office) {

    }

    @Override
    public void delete(Long id) {

    }
}
