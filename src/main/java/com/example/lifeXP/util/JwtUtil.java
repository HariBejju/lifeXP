package com.example.lifeXP.util;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
    
    private String secret;

    private final Key secretKey;
    private final long expirationTime = 1000*60*60*24;
    
    public JwtUtil(@Value("${jwt.secret}")String secret){
       this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
    public  String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .signWith(secretKey)
                .compact();
    }
     public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
