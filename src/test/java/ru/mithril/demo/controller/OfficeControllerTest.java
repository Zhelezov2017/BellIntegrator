package ru.mithril.demo.controller;

import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mithril.demo.view.OfficeView;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
public class OfficeControllerTest {



    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;

    private static OfficeView officeView = new OfficeView(Long.getLong("1"),"BellIntegrator","ул Керженец д15","2-534-32-43",true,"1423");


    @Test
    public void setOffice() throws JSONException {
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView , header);


    }

    @Test
    public void getOffices() throws JSONException {
        ArrayList<OfficeView> arrayList = new ArrayList<>();
        arrayList.add(officeView);
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView, header);

    }

    @Test
    public void getOffice() throws JSONException {
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(null, header);

    }

    @Test
    public void updateOffice() throws JSONException {
        officeView.setAddress("ул Кривово д17");
        officeView.setName("Programma T");
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView, header);

    }
}