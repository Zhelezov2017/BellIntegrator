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
import ru.mithril.demo.view.CountryView;

import java.util.ArrayList;

import static org.json.JSONObject.wrap;

@RunWith(SpringRunner.class)
public class CountryControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;


    private static CountryView countryView1 = new CountryView("torino","432523");
    private static CountryView countryView2 = new CountryView("rotrin","43253");
    private static CountryView countryView3 = new CountryView("bellIntegratot","43252343");

    @Test
    public void get() throws JSONException {
        ArrayList<CountryView> arrayList = new ArrayList<>();
        arrayList.add(countryView1);
        arrayList.add(countryView2);
        arrayList.add(countryView3);
        HttpEntity<CountryView> countryViewHttpEntity = new HttpEntity<>(countryView1, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/list", HttpMethod.POST, countryViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(arrayList)), response.getBody(), false);
    }
}