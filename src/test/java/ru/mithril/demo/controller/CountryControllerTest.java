package ru.mithril.demo.controller;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mithril.demo.view.CountryView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryControllerTest {


    @LocalServerPort
    private int port = 8888;

    private ControllerProTest tester;
    private CountryView filterPattern2;
    private List<CountryView> listNow;
    private static CountryView countryView1 = new CountryView("torino","432523");
    private static CountryView countryView2 = new CountryView("rotrin","43253");
    private static CountryView countryView3 = new CountryView("bellIntegratot","43252343");

    @Test
    public void get() throws JSONException {
        listNow = new ArrayList<>();
        listNow.add(countryView1);
        listNow.add(countryView2);
        Assert.assertTrue(tester.testPost(filterPattern2, listNow, POST, "list"));
    }


}