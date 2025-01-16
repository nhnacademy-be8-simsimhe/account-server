package com.simsimbookstore.accountserver.controller;


import com.simsimbookstore.accountserver.dto.JwtGenerateRequestDto;
import com.simsimbookstore.accountserver.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JwtProperties jwtProperties;

    @PostMapping("/users/jwt")
    public ResponseEntity<?> generateJwt(
            @RequestBody JwtGenerateRequestDto requestDto
            ){
        String accessToken = jwtProperties.generateAccessToken(requestDto);
        String refreshToken = jwtProperties.generateRefreshToken(requestDto);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken",accessToken);
        tokenMap.put("refreshToken",refreshToken);

        return ResponseEntity.ok(tokenMap);
    }
}
