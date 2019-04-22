package ru.mithril.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mithril.demo.model.user.service.Office;
import ru.mithril.demo.service.serviceInterface.OfficeService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/officeAdd")
    public void addOffice(@RequestBody Office office) {
        officeService.add(office);
    }

    @ApiOperation(value = "Получить список всех офисов", httpMethod = "GET")
    @GetMapping("/officeGetAll")
    public List<Office> getOffices() {
        return officeService.offices();
    }

    @ApiOperation(value = "Получить офис по id", httpMethod = "GET")
    @GetMapping("/officeGetID")
    public Optional getOffice() {
        return officeService.find(Long.getLong("1"));
    }

    @PutMapping(value = "{officeID}")
    public void updateUser(@RequestBody @Valid Office office,
                           @PathVariable("officeID") Long id) throws EntityNotFoundException {
        Optional<Office> off = officeService.find(id);
        if (!off.isPresent())
            throw new EntityNotFoundException("id-" + id);
        officeService.update(office);
    }

    @DeleteMapping(value = "/{offId}")
    public void deleteUser(@PathVariable("offId") Long id)
            throws EntityNotFoundException {
        Optional<Office> p = officeService.find(id);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + id);
        officeService.delete(id);
    }

}
