package com.simsimbookstore.accountserver.controller;


import com.simsimbookstore.accountserver.properties.JwtProperties;
import com.simsimbookstore.accountserver.request.LocalUserRequest;
import com.simsimbookstore.accountserver.entity.LocalUser;
import com.simsimbookstore.accountserver.entity.User;
import com.simsimbookstore.accountserver.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final JwtProperties jwtProperties;

    public UserController(UserService userService, JwtProperties jwtProperties) {
        this.userService = userService;
        this.jwtProperties = jwtProperties;
    }

    //회원가입
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody LocalUserRequest localUserRequest) {
        User saveUser = userService.save(localUserRequest);
        return ResponseEntity.ok(saveUser);
    }

    // 로컬 유저 단건 조회
    @GetMapping("/users/localUsers/{loginId}")
    public LocalUser findLocalUser(@PathVariable String loginId) {
        LocalUser localUser = userService.findByLoginId(loginId);
        return localUser;
    }

    //토큰 발급
    @GetMapping("/users/localUsers/{loginId}/jwt")
    public ResponseEntity<?> generateJwt(@PathVariable String loginId){

        String jwt = jwtProperties.generateJwt(loginId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String test(){
        return "Hello World";
    }
}
