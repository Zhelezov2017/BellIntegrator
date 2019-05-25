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
import ru.mithril.demo.service.serviceInterface.OrganizationService;
import ru.mithril.demo.view.OrganizationView;
import ru.mithril.demo.view.operations.organization.ListOrganization;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    @Autowired
    private final OrganizationService organizationService;
    public static final Logger logger = LoggerFactory.getLogger(OfficeController.class);
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }

    @Autowired
    public OrganizationController (OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity<?> setOrganization(@RequestBody @Valid OrganizationView organization) {
        logger.info("Creating Organization : {}", organization);

        organizationService.add(organization);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Получить список всех организаций", httpMethod = "GET")
    @GetMapping("/list")
    public List<OrganizationView> getOrganization(@Validated(ListOrganization.class) @RequestBody OrganizationView organizationView) {
        return organizationService.organizations(organizationView);
    }

    @ApiOperation(value = "Получить организацию по id", httpMethod = "GET")
    @GetMapping("/{organizationID}")
    public OrganizationView getOrganization(@PathVariable("organizationID") Long id) throws EntityNotFoundException {
        organizationService.find(id);
        OrganizationView organization = organizationService.find(id);
        return organization;
    }


    @PutMapping(value = "/update",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<Object> updateOrganization(@RequestBody @Valid OrganizationView organizationView) throws EntityNotFoundException {
        organizationService.update(organizationView);
        return ResponseEntity.ok().body(organizationView);
    }
}
