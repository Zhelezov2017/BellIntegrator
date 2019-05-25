package ru.mithril.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mithril.demo.service.serviceInterface.OfficeService;
import ru.mithril.demo.view.OfficeView;
import ru.mithril.demo.view.operations.office.ListOffice;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    @Autowired
    private final OfficeService officeService;
    public static final Logger logger = LoggerFactory.getLogger(OfficeController.class);
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity<?> setOffice(@RequestBody @Valid OfficeView office) {
        logger.info("Creating Office : {}", office);

        officeService.add(office);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Получить список всех офисов", httpMethod = "GET")
    @GetMapping("/list")
    public List<OfficeView> getOffices(@Validated(ListOffice.class) @RequestBody OfficeView officeView) {
        return officeService.offices(officeView);
    }

    @ApiOperation(value = "Получить офис по id", httpMethod = "GET")
    @GetMapping("/{officeID}")
    public OfficeView getOffice(@PathVariable("officeID") Long id) throws EntityNotFoundException {
        officeService.find(id);
        OfficeView office = officeService.find(id);
        return office;
    }


    @PutMapping(value = "/update",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<Object> updateOffice(@RequestBody @Valid OfficeView officeView) throws EntityNotFoundException {
        officeService.update(officeView);
        return ResponseEntity.ok().body(officeView);
    }

}
