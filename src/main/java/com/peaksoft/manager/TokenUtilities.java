package com.peaksoft.manager;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class TokenUtilities {

    private final String secret = "javaSeven";

    // generate token
    public String generateToken(String email) {
        return JWT.create()
                .withClaim("email", email)
                .sign(Algorithm.HMAC512(secret));
    }

    // validate token
    public String validateToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secret)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getClaim("email").asString();
    }

}
