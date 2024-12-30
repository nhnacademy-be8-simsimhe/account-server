package com.simsimbookstore.accountserver.controller;


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

    //토큰 발급
    @PostMapping("/users/localUsers/{loginId}/jwt")
    public ResponseEntity<?> generateJwt(@PathVariable String loginId){

        String accessToken = jwtProperties.generateAccessToken(loginId);
        String refreshToken = jwtProperties.generateRefreshToken(loginId);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken",accessToken);
        tokenMap.put("refreshToken",refreshToken);

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + jwt);
//        return new ResponseEntity<>(headers, HttpStatus.OK);

        return ResponseEntity.ok(tokenMap);
    }
}
