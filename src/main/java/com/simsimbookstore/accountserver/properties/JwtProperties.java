package com.simsimbookstore.accountserver.properties;

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

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix="jwt")
public class JwtProperties {

    @Value("${jwt.secret}")
    private String secret;

    public String generateAccessToken(String loginId){
        int expirationTime = 3600; // 1시간
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expirationTime);

        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .subject(loginId)
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(secretKey)
                .compact();
    }

    public String generateRefreshToken(String loginId){
        int expirationTime = 7 * 24 * 3600; //7 일
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expirationTime);

        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .subject(loginId)
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(secretKey)
                .compact();
    }
}

