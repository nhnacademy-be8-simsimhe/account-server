package com.simsimbookstore.accountserver.properties;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
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

    private String secret;
    private Integer expirationTime;
    private String tokenPrefix;
    private String headerString;
    private String loginUrl;

    public String generateJwt(String loginId){
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

