package ru.mithril.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mithril.demo.dao.daoInterface.OfficeDaoJdbcTemplateImpl;
import ru.mithril.demo.model.user.service.Office;
@RunWith(SpringRunner.class)
public class OfficeControllerTest {

    @MockBean
    public OfficeController officeController;

    @Test
    public void addOffice() {
        Office office = new Office(new Long("4"),"Sevocard", "Radio");
        officeController.addOffice(office);
    }

    @Test
    public void getOffices() {
        Office office = new Office(new Long("4"),"Sevocard", "Radio");
        officeController.getOffices();
    }

    @Test
    public void getOffice() {
        officeController.getOffice();
    }

    @Test
    public void updateUser() {
        Office office = OfficeDaoJdbcTemplateImpl.offices.get(new Long("2"));
        officeController.updateUser(office, new Long("3"));
        officeController.deleteUser(new Long("3"));
    }

    @Test
    public void deleteUser() {
        officeController.deleteUser(new Long("3"));
    }
}