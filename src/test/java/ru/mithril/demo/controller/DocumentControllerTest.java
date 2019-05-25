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
import ru.mithril.demo.view.DocumentView;

import java.util.ArrayList;

import static org.json.JSONObject.wrap;

@RunWith(SpringRunner.class)
public class DocumentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpHeaders header;

    @Autowired
    private Gson json;

    private static DocumentView documentView1 = new DocumentView("torino","432523");
    private static DocumentView documentView2 = new DocumentView("rotrin","43253");
    private static DocumentView documentView3 = new DocumentView("bellIntegratot","43252343");

    @Test
    public void get() throws JSONException {
        ArrayList<DocumentView> arrayList = new ArrayList<>();
        arrayList.add(documentView1);
        arrayList.add(documentView2);
        arrayList.add(documentView3);
        HttpEntity<DocumentView> documentViewHttpEntity = new HttpEntity<>(documentView1, header);
        ResponseEntity<String> response = testRestTemplate.exchange("/list", HttpMethod.POST, documentViewHttpEntity, String.class);
        JSONAssert.assertEquals(json.toJson(wrap(arrayList)), response.getBody(), false);
    }
}