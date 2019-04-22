package ru.mithril.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mithril.demo.model.user.service.User;
import ru.mithril.demo.service.serviceInterface.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController", description = "Управление информацией о пользователях")
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private final UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Добавить нового пользователя", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/userAdd")
    public void setUser(@RequestBody @Valid User user) {
        userService.add(user);
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/userGetAll")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.users();
        return ResponseEntity.ok().body(users);
    }

    @ApiOperation(value = "Получить человека по id", httpMethod = "GET")
    @GetMapping("/{userID}")
    public ResponseEntity<User> getUser(@PathVariable("userID") Long id) throws EntityNotFoundException {
        Optional<User> user = userService.find(id);
        if (!user.isPresent())
            throw new EntityNotFoundException("id-" + id);
        return ResponseEntity.ok().body(user.get());
    }


    @PutMapping(value = "{userID}")
    public void updateUser(@RequestBody @Valid User user,
                                               @PathVariable("userID") Long id) throws EntityNotFoundException {
        Optional<User> us = userService.find(id);
        if (!us.isPresent())
            throw new EntityNotFoundException("id-" + id);
        userService.update(user);
    }

    @DeleteMapping(value = "/{usId}")
    public void deleteUser(@PathVariable("usId") Long id)
            throws EntityNotFoundException {
        Optional<User> p = userService.find(id);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + id);
        userService.delete(id);
    }


}
