package com.microservice.authserve.security;

import com.microservice.authserve.dto.RequestDTO;
import com.microservice.authserve.entity.AuthUser;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;

@Slf4j
public class JwtProvider {

    private static final Key LlAVE_SECRETA = new SecretKeySpec("secretnameforsecurityKrug3rM3d$$@drds@h17".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    @Autowired
    private static RouteValidator routeValidator;

    @Autowired
    private static RouteValidatorClient routeValidatorClient;

    @Autowired
    private static RouteValidatorRepartidor routeValidatorRepartidor;

    public static String createToken(AuthUser authUser){
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(authUser.getEmail());
        claims.put("id", authUser.getId());
        claims.put("role", authUser.getRole());
        log.info("creando claims");
        Date now = new Date();
        Date expired = new Date(now.getTime() + 86400000);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expired)
                .signWith(LlAVE_SECRETA)
                .compact();
    }

    public static boolean validate(String token, RequestDTO dto) {
        try {
            JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
            parser.parseClaimsJws(token);

            log.info("Entrando a la validacion, creacion de parseclaim exitosa");
        }catch (Exception e) {
            return false;
        }
        if (!isAdmin(token) && routeValidator.isAdminPath(dto)){
            return false;
        }
        log.info("retorna un true de provider");
        return true;
    }

    public static boolean validateClient(String token, RequestDTO dto){
        try{
            JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
            parser.parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return isClient(token) || !routeValidatorClient.isClientPath(dto);
    }

    public static boolean validateRepartidor(String token, RequestDTO dto){
        try {
            JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
            parser.parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return isRepartidor(token) || !routeValidatorRepartidor.inRepartidorPath(dto);
    }


    public static String getEmailFromUser(String token){
        log.info("entrando a la validacion del email");
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        return parser.parseClaimsJws(token).getBody().getSubject();
    }

    private static boolean isAdmin(String token){
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        log.info("verificar si es admin: {}", parser.parseClaimsJws(token).getBody().get("role").equals("ADMIN"));
        return parser.parseClaimsJws(token).getBody().get("role").equals("ADMIN");
    }

    private static boolean isRepartidor(String token){
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        return parser.parseClaimsJws(token).getBody().get("role").equals("REPARTIDOR");
    }

    private static boolean isClient(String token){
        JwtParser parser = Jwts.parserBuilder().setSigningKey(LlAVE_SECRETA).build();
        return parser.parseClaimsJws(token).getBody().get("role").equals("CLIENTE");
    }

}
