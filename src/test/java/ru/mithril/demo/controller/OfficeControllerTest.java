package ru.mithril.demo.controller;

import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mithril.demo.view.OfficeView;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.json.JSONObject.wrap;
import static ru.exception.com.springboot.ResponseBodyException.SUCCESS_RESPONSE_BODY;

@RunWith(SpringRunner.class)
public class OfficeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;

    private static OfficeView officeView = new OfficeView(Long.getLong("1"),"BellIntegrator","ул Керженец д15","2-534-32-43",true,"1423");


    @Test
    public void setOffice() throws JSONException {
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView , header);
        ResponseEntity<String> response = testRestTemplate.exchange("/save", HttpMethod.POST, officeViewHttpEntity, String.class);
        String location = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(location.contains("/1"));
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }

    @Test
    public void getOffices() throws JSONException {
        ArrayList<OfficeView> arrayList = new ArrayList<>();
        arrayList.add(officeView);
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/list", HttpMethod.POST, officeViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(arrayList)), response.getBody(), false);
    }

    @Test
    public void getOffice() throws JSONException {
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/2", HttpMethod.GET, officeViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(officeView)), response.getBody(), false);
    }

    @Test
    public void updateOffice() throws JSONException {
        officeView.setAddress("ул Кривово д17");
        officeView.setName("Programma T");
        HttpEntity<OfficeView> officeViewHttpEntity = new HttpEntity<>(officeView, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/update", HttpMethod.POST, officeViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }
}