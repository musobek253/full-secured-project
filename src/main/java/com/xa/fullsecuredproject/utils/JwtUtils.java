package com.xa.fullsecuredproject.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtils {
    public static int expire=900000000;
    public static String secret="gfhg4561967$%#%$%^?>?>:gjhgsdfsd?>jahdqpdsdhgf";
    public static Date getExpireDate(){
        return new Date(expire+System.currentTimeMillis());
    }
    public static Date getExpireDateForRefreshToken(){
        return new Date(expire+System.currentTimeMillis()+ 1000L *3600*24*10);
    }
    public static Algorithm getAlgorithm(){
        return Algorithm.HMAC256(secret.getBytes(StandardCharsets.UTF_8));
    }

    public static JWTVerifier verifier() {
        return JWT.require(getAlgorithm()).build();
    }
}
