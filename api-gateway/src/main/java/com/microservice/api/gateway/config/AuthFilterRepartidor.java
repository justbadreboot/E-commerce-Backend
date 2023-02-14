package com.microservice.api.gateway.config;
/*
import com.microservice.api.gateway.dto.RequestDTO;
import com.microservice.api.gateway.dto.TokenDTO;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilterRepartidor extends AbstractGatewayFilterFactory<AuthFilterRepartidor.Config> {

    private WebClient.Builder webClient;

    public AuthFilterRepartidor(WebClient.Builder webClient){
        super(Config.class);
        this.webClient=webClient;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            String tokenHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String [] chunks = tokenHeader.split(" ");
            if (chunks.length !=2 || !chunks[0].equals("Bearer")){
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            return webClient.build()
                    .post()
                    .uri("https://authserve-production.up.railway.app/auth/validate/repartidor?token="+ chunks[1])
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



    public static class Config{}

}
.
 */
