package org.example.controller.v1;

import org.example.model.dto.request.UserCreateDtoRequest;
import org.example.model.dto.response.UserDtoResponse;
import org.example.service.api.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Создание нового пользователя
     */
    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserCreateDtoRequest request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    /**
     * Получение пользователя по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }
}
