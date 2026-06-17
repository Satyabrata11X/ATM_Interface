package com.ATM_Machine_Interface.ATM_Machine_Interface.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                userService.registerUser(request)
        );
    }
}