package com.collega.otomasi_datacenter.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private String SECRET_KEY = "+wQRvrJOyD09iRRiGsX4HXQQvQ05tghwKMAxaWExutD+d0ozWJqMRvho0oHKI3iFSgx3WMAl1eq1cTYTtYSvc4OorfLxB8DKtnTmWt0znl1Wgguy6ao8tYyCjal6wli9Tngv0DO7XwKr2Qs+EZNlVGxncByPp0x6wmLcPG0aXKeCB2kQpKaPH1fVPWt/BYfixrsGoqBYAp/UY2dFF62cU3ek4BEiJTcM1OeCtTcV9SsIEAHSr+FvHuES8LNjJh5+g56ARWH/f8GeJ/5/sJIA7dk0RZCbC8yX4JQlpvQFPyhJEufI5tP7FTQ6oyqNPkwlM6B1v7fdeQkWFVVO/+xU/HVdm7NLO+5I/AurNDIDn88";

    @SuppressWarnings("deprecation")
    private Claims extractAllClaims(String token){
        // return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return Jwts
            .parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    @SuppressWarnings("deprecation")
    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
