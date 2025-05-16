package com.example.demo.jwt;

import java.security.Key;
import java.util.Base64;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	    public boolean isTokenValid(String token) {
	        try {
	            Jws<Claims> claims = Jwts.parserBuilder()
	            	    .setSigningKey(getSignKey())
	            	    .build()
	            	    .parseClaimsJws(token);

	            
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    private Key getSignKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
}
