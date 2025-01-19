package com.simsimbookstore.accountserver.properties;

import com.simsimbookstore.accountserver.dto.JwtGenerateRequestDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix="jwt")
public class JwtProperties {

    @Value("${jwt.secret}")
    private String secret;

    public String generateAccessToken(JwtGenerateRequestDto request) {
        int expirationTime = 20; // 1시간
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expirationTime);

        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        Map<String, Object> claims = new HashMap<>();
        claims.put("isSocial", request.isSocial());
        claims.put("userId", request.getUserId());
        claims.put("roles", request.getRoles());

        return Jwts.builder()
                .subject(request.getSubject())
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(secretKey)
                .claims(claims)
                .compact();
    }

    public String generateRefreshToken(JwtGenerateRequestDto request) {
        int expirationTime = 7 * 24 * 3600; //7 일
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expirationTime);

        Map<String, Object> claims = new HashMap<>();
        claims.put("isSocial", request.isSocial());
        claims.put("userId", request.getUserId());
        claims.put("roles", request.getRoles());
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .subject(String.valueOf(request.getSubject()))
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(secretKey)
                .claims(claims)
                .compact();
    }
}

