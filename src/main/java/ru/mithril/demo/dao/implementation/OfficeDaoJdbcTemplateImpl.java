package ru.mithril.demo.dao.implementation;


import ru.mithril.demo.model.user.service.Office;
import ru.mithril.demo.service.serviceInterface.OfficeService;
import ru.mithril.demo.view.OfficeView;

import java.util.*;

public class OfficeDaoJdbcTemplateImpl implements OfficeService {



    public static  Map<Long, Office> offices = new HashMap<>();


    public OfficeDaoJdbcTemplateImpl() {
        //Office shelter = new Office(new Long("1"), "Shelter", "ул. Прыгунова 47", "9871524", "1", "1", new Long("0"));
        //Office secondOffice = new Office(new Long("2"), "SecondOffice", "ул. Иванова 7", "2233424", "1", "1", new Long("0"));
        //Office firstOffice = new Office(new Long("3"), "FirstOffice", "ул. Иванова 8", "2136434", "1", "2", new Long("0"));


        //offices.put(shelter.id, shelter);
        //offices.put(secondOffice.id, secondOffice);
        //offices.put(firstOffice.id, firstOffice);

    }


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
        offices.remove(id);
    }
}
