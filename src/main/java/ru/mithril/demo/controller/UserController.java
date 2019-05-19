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
import ru.exception.com.springboot.CustomErrorType;
import ru.mithril.demo.service.serviceInterface.UserService;
import ru.mithril.demo.view.UserView;
import ru.mithril.demo.view.operations.user.ListUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController", description = "Управление информацией о пользователях")
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private final UserService userService;
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
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
    @PostMapping("/save")
    public ResponseEntity<?> setUser(@RequestBody @Valid UserView user) {
        logger.info("Creating User : {}", user);

        if (userService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getFirstName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    user.getFirstName() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.add(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/list")
    public List<UserView> getUsers(@Validated(ListUser.class) @RequestBody UserView userView) {
        return userService.users(userView);
    }

    @ApiOperation(value = "Получить человека по id", httpMethod = "GET")
    @GetMapping("/{userID}")
    public UserView getUser(@PathVariable("userID") Long id) throws EntityNotFoundException {
        userService.find(id);
        UserView user = userService.find(id);
        return user;
    }


    @PutMapping(value = "/update",
    consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserView user) throws EntityNotFoundException {
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }

//    @DeleteMapping(value = "/{userId}")
//    public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long id)
//            throws EntityNotFoundException {
//        userService.delete(id);
//        return ResponseEntity.ok().build();
//    }




}
