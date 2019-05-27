package ru.mithril.demo.controller;


import com.google.gson.Gson;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import ru.exception.com.springboot.JSONResponseWrapper;
import ru.exception.com.springboot.ResponseBodyMarker;
import ru.mithril.demo.view.OfficeView;

public class ControllerProTest {

    private static TestRestTemplate restTemplate = new TestRestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private static Gson gson = new Gson();

    private String srvName;
    private int port;

    public ControllerProTest(int port, String srvName) {
        this.port = port;
        this.srvName = srvName;
    }


    public boolean testGet(Object expected) throws JSONException {
        return testGet(null, expected);
    }

    public boolean testGet(Object param, Object expected) throws JSONException {
        HttpEntity<OfficeView> entity = new HttpEntity<>(null, headers);

        String uri;
        if (param == null) {
            uri = "";
        }
        else {
            uri = param.toString();
        }

        String responseBody = restTemplate.exchange(
                createURLWithPort("/" + uri),
                HttpMethod.GET,
                entity,
                String.class
        ).getBody();

        if (!(expected instanceof ResponseBodyMarker)) {
            expected = wrap(expected);
        }

        return JSONCompare.compareJSON(
                gson.toJson(expected),
                responseBody,
                JSONCompareMode.NON_EXTENSIBLE
        ).passed();
    }

    public boolean testPost(Object sent, Object expected, HttpMethod method, String uri) throws JSONException {
        HttpEntity<?> entity = new HttpEntity<>(sent, headers);

        String responseBody = restTemplate.exchange(
                createURLWithPort("/" + uri),
                method,
                entity,
                String.class
        ).getBody();

        if (!(expected instanceof ResponseBodyMarker)) {
            expected = wrap(expected);
        }

        return JSONCompare.compareJSON(
                gson.toJson(expected),
                responseBody,
                JSONCompareMode.NON_EXTENSIBLE
        ).passed();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/api/" + srvName + uri;
    }

    private static <T> JSONResponseWrapper.Wrapper wrap(T o) {
        return new JSONResponseWrapper.Wrapper<>(o);
    }
}
