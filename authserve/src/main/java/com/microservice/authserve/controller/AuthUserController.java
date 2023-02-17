package com.microservice.authserve.controller;

import com.microservice.authserve.dto.*;
import com.microservice.authserve.entity.AuthUser;
import com.microservice.authserve.service.AuthUserService;
import com.microservice.authserve.service.AuthUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin(value = "*")
public class AuthUserController {

    @Autowired
    private AuthUserServiceImpl authUserService;


    //@CrossOrigin(value = "*")
    @PostMapping("/login")
    private ResponseEntity<TokenDTO> login (@RequestBody LoginUserDTO authUserDTO){
        TokenDTO tokenDTO = authUserService.userLogin(authUserDTO);
        if (tokenDTO == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDTO);
    }

    //@CrossOrigin(value = "*")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NewUserDto dto) throws Exception {
        AuthUser authUser = authUserService.crear(dto);
        if (authUser == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya se encuentra registrado");
        }
        return ResponseEntity.ok(authUser);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> validarMail(@PathVariable(value = "email") String dto){
        ResponseDtoValidate responseDtoValidate = authUserService.validarEmail(dto);
        if (responseDtoValidate == null){
            return ResponseEntity.ok("El correo NO se encuentra registrado");
        }
        return ResponseEntity.ok(responseDtoValidate);
    }


   // @CrossOrigin(origins = "https://api-gateway-production-d841.up.railway.app")
    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate (@RequestParam String token, @RequestBody RequestDTO dto){
        log.info("entra al endpoint de validate");
        TokenDTO tokenDTO = authUserService.validate(token, dto);
        log.info("comprueba el token en auuthservice y validate");
        if (tokenDTO ==null){
            log.info("la respuesta del token es null");
            return ResponseEntity.badRequest().build();
        }
        log.info("validacion exitosa");
        return ResponseEntity.ok(tokenDTO);
    }
   // @CrossOrigin(origins = "https://api-gateway-production-d841.up.railway.app")
    @PostMapping("validate/client")
    public ResponseEntity<?> validateClient(@RequestParam String token, @RequestBody RequestDTO dto){
        TokenDTO tokenDTO = authUserService.validateRolClient(token, dto);
        if (tokenDTO==null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Rol no autorizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }

   // @CrossOrigin(origins = "https://api-gateway-production-d841.up.railway.app")
    @PostMapping("validate/repartidor")
    public ResponseEntity<?> validateRepartidor(@RequestParam String token, @RequestBody RequestDTO dto){
        TokenDTO tokenDTO = authUserService.validateRolRepartidor(token, dto);
        if (tokenDTO == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Rol no autorizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }


}
