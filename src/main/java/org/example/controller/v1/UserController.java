package org.example.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.example.model.dto.request.UserCreateDtoRequest;
import org.example.model.dto.response.UserDtoResponse;
import org.example.service.api.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Пользователи", description = "API для управления пользователями")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Создание нового пользователя
     */
    @PostMapping
    @Operation(summary = "Создание нового пользователя", description = "Создаёт нового пользователя в системе")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь успешно создан"),
            @ApiResponse(code = 400, message = "Некорректные данные"),
            @ApiResponse(code = 409, message = "Email или телефон уже существует")
    })
    public ResponseEntity<Long> createUser(@RequestBody UserCreateDtoRequest request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    /**
     * Получение пользователя по ID
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по id")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }
}
