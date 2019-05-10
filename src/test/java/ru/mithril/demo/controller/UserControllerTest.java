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
import ru.mithril.demo.view.UserView;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.json.JSONObject.wrap;
import static ru.exception.com.springboot.ResponseBodyException.SUCCESS_RESPONSE_BODY;


@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;

    private static UserView user = new UserView(Long.getLong("1"),"Anton", "Ingener", 1, "Petrovich", "Saraev");

    @Test
    public void welcome() {

    }

    @Test
    public void setUser() throws JSONException {
        HttpEntity<UserView> userViewHttpEntity = new HttpEntity<>(user , header);
        ResponseEntity<String> response = testRestTemplate.exchange("/save", HttpMethod.POST, userViewHttpEntity, String.class);
        String location = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(location.contains("/1"));
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }

    @Test
    public void getUsers() throws JSONException{
        ArrayList<UserView> arrayList = new ArrayList<>();
        arrayList.add(user);
        HttpEntity<UserView> userViewHttpEntity = new HttpEntity<>(user, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/list", HttpMethod.POST, userViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(arrayList)), response.getBody(), false);
    }

    @Test
    public void getUser() throws JSONException {
        HttpEntity<UserView> userViewHttpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/2", HttpMethod.GET, userViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(user)), response.getBody(), false);
    }

    @Test
    public void updateUser() throws JSONException{
        user.setFirstName("Artem");
        user.setPosition("Programist");
        HttpEntity<UserView> userViewHttpEntity = new HttpEntity<>(user, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/update", HttpMethod.POST, userViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(SUCCESS_RESPONSE_BODY), response.getBody(), false);
    }
}