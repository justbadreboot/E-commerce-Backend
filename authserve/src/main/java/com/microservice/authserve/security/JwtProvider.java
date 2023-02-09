package com.microservice.authserve.security;

import com.microservice.authserve.dto.RequestDTO;
import com.microservice.authserve.entity.AuthUser;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;

//@Component
@Slf4j
public class JwtProvider {
    @Value("${jwt-secret-word}")
    private static String secret;
    private static final Key LlAVE_SECRETA = new SecretKeySpec("secretnameforsecurityKrug3rM3d$$@drds@h17".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    private static final long TIEMPO_EXPIRACION = 3600_000;
    @Autowired
    private static RouteValidator routeValidator;
    public static String createToken(AuthUser authUser){
        Map<String, Object> claims = new HashMap<>();
        log.info("entrando a funcion de crear token");
        claims = Jwts.claims().setSubject(authUser.getEmail());
        claims.put("id", authUser.getId());
        claims.put("role", authUser.getRole());
        log.info("creando claims");
        Date now = new Date();
        Date expired = new Date(now.getTime() + 3600000);
        return Jwts.builder()
                .setClaims(claims)
                //.setIssuedAt(now)
                .setExpiration(expired)
                .signWith(LlAVE_SECRETA)
                .compact();
    }

    public static boolean validate(String token, RequestDTO dto) {
        try {
            Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build().parseClaimsJwt(token);
        }catch (Exception e) {
            return false;
        }
        if (!isAdmin(token) && routeValidator.isAdminPath(dto)){
            return false;
        }
        return true;
    }

    public static String getEmailFromUser(String token){
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        return parser.parseClaimsJwt(token).getBody().getSubject();
    }

    private static boolean isAdmin(String token){
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        return parser.parseClaimsJwt(token).getBody().get("role").equals("ADMIN");
    }

}
