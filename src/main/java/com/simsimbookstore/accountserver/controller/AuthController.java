package com.simsimbookstore.accountserver.controller;


import com.simsimbookstore.accountserver.request.LoginRequest;
import com.simsimbookstore.accountserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class AuthController {
    private final UserService userService;

    @PostMapping("/auth/jwt")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean login = userService.login(loginRequest);
        return ResponseEntity.ok(login);
    }
}
