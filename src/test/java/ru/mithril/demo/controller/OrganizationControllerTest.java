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
import ru.mithril.demo.view.OrganizationView;
import ru.mithril.demo.view.UserView;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.json.JSONObject.wrap;
import static ru.exception.com.springboot.ResponseBodyException.SUCCESS_RESPONSE_BODY;

@RunWith(SpringRunner.class)
public class OrganizationControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;

    private static OrganizationView organizationView = new OrganizationView("BellInt","BellIntegrator","2634534","87464","ул Керженек","2547867",true);

    @Test
    public void setOrganization() throws JSONException {
        HttpEntity<OrganizationView> organizationViewHttpEntity = new HttpEntity<>(organizationView , header);
        ResponseEntity<String> response = testRestTemplate.exchange("/save", HttpMethod.POST, organizationViewHttpEntity, String.class);
        String location = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(location.contains("/1"));
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }

    @Test
    public void getOrganization() throws JSONException {
        ArrayList<OrganizationView> arrayList = new ArrayList<>();
        arrayList.add(organizationView);
        HttpEntity<OrganizationView> organizationViewHttpEntity = new HttpEntity<>(organizationView, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/list", HttpMethod.POST, organizationViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(arrayList)), response.getBody(), false);
    }

    @Test
    public void getOrganization1() throws JSONException {
        HttpEntity<UserView> userViewHttpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/2", HttpMethod.GET, userViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(organizationView)), response.getBody(), false);
    }

    @Test
    public void updateOrganization() throws JSONException {
        organizationView.setFullName("Intel");
        organizationView.setAddress("ул Красавченко д 17б");
        HttpEntity<OrganizationView> organizationViewHttpEntity = new HttpEntity<>(organizationView, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/update", HttpMethod.POST, organizationViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }
}