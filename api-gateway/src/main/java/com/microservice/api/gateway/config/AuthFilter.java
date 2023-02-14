package com.microservice.api.gateway.config;

import com.microservice.api.gateway.dto.RequestDTO;
import com.microservice.api.gateway.dto.TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Slf4j
@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private WebClient.Builder webClient;

    public AuthFilter(WebClient.Builder webClient){
        super(Config.class);
        this.webClient=webClient;
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.info("entra al filtro de gateway");
        return (((exchange, chain) -> {
            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                log.info("error al contener la autorizacion");
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            String tokenHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String [] chunks = tokenHeader.split(" ");
            if (chunks.length !=2 || !chunks[0].equals("Bearer")){
                log.info("el token no coincide");
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            log.info("realiza el retorno con la peticion hacia el auth service de validacion de token");
            return webClient.build()
                    .post()
                    .uri("https://authserve-production.up.railway.app/auth/validate?token="+ chunks[1])
                    .bodyValue(new RequestDTO(exchange.getRequest().getPath().toString(), exchange.getRequest().getMethod().toString()))
                    .retrieve().bodyToMono(TokenDTO.class)
                    .map(t -> {
                        t.getToken();
                        return exchange;
                    }).flatMap(chain::filter);
        }));
    }

    public Mono<Void> onError(ServerWebExchange exchange, HttpStatus status){
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        return response.setComplete();
    }

    public Mono<?> onErrorPersonalizado(){
        HashMap<String, Object> respuesta = new HashMap<>();
        respuesta.put("Errr Request:", HttpStatus.BAD_REQUEST);
        respuesta.put("message: ", "No con tiene la palabra Bearer en el token o un espacio");
        return Mono.just(respuesta);
    }
    public Mono<?> onErrorPersonalizadoHeader(){
        HashMap<String, Object> respuesta = new HashMap<>();
        respuesta.put("Errr Request:", HttpStatus.BAD_REQUEST);
        respuesta.put("message: ", "No tiene la cabecera de Authentication en la solicitud");
        return Mono.just(respuesta);
    }

    public static class Config{}

}
