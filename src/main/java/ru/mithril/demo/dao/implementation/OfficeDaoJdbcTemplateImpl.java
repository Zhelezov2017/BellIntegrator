package ru.mithril.demo.dao.implementation;


import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.mithril.demo.dao.daoInterface.OfficeDao;
import ru.mithril.demo.model.user.service.Office;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@Data
public class OfficeDaoJdbcTemplateImpl implements OfficeDao {

    private final EntityManager em;

    public static  Map<Long, Office> offices = new HashMap<>();


    public OfficeDaoJdbcTemplateImpl(EntityManager em) {
        //Office shelter = new Office(new Long("1"), "Shelter", "ул. Прыгунова 47", "9871524", "1", "1", new Long("0"));
        //Office secondOffice = new Office(new Long("2"), "SecondOffice", "ул. Иванова 7", "2233424", "1", "1", new Long("0"));
        //Office firstOffice = new Office(new Long("3"), "FirstOffice", "ул. Иванова 8", "2136434", "1", "2", new Long("0"));


        //offices.put(shelter.id, shelter);
        //offices.put(secondOffice.id, secondOffice);
        //offices.put(firstOffice.id, firstOffice);

        this.em = em;
    }


    @Override
    public List<ru.mithril.demo.model.Office> office(ru.mithril.demo.model.Office office) {
        return null;
    }

    @Override
    public ru.mithril.demo.model.Office find(Long id) {
        return null;
    }

    @Override
    public void add(ru.mithril.demo.model.Office model) {

    }

    @Override
    public void update(ru.mithril.demo.model.Office model) {

    }

    @Override
    public void delete(Long id) {

    }
}
