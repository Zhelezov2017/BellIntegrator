package ru.mithril.demo.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

   /* private final OrganizationService userService;

    @Autowired
    public OrganizationController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Добавить нового пользователя", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/userAdd")
    public void user(@RequestBody User user) {
        userService.add(user);
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/userGetAll")
    public List<User> users() {
        return userService.users();
    }

    @ApiOperation(value = "Получить человека по id", httpMethod = "GET")
    @GetMapping("/userGetID")
    public Optional user() {
        return userService.find(Long.getLong("1"));
    }*/
}
