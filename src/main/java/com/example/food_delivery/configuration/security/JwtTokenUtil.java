package com.example.food_delivery.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    public static final String SECRET_KEY = "7134743777217A25432A462D4A614E645267556B58703272357538782F413F44";

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuer("https://food_delivery.uz")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .signWith(signKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValid(String token){
        try {
            Claims claims = getClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getEmail(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(signKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key signKey(){
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

}
