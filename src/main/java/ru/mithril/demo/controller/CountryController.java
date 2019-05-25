package ru.mithril.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mithril.demo.service.serviceInterface.CountryService;
import ru.mithril.demo.view.CountryView;
import ru.mithril.demo.view.operations.country.ListCountry;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "CountryController", description = "Управление информацией о странах")
@RestController
@RequestMapping(value = "/country", produces = APPLICATION_JSON_VALUE)
public class CountryController {


    @Autowired
    private final CountryService countryService;
    public static final Logger logger = LoggerFactory.getLogger(CountryController.class);
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ApiOperation(value = "Получить список всех стран", httpMethod = "GET")
    @GetMapping("/list")
    public List<CountryView> get(@Validated(ListCountry.class) @RequestBody CountryView countryView) {
        return countryService.country(countryView);
    }

}
