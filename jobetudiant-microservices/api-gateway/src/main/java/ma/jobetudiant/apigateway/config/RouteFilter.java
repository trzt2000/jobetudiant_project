package ma.jobetudiant.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



@Component
public class RouteFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            System.out.println("custom global filter");
            //String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            exchange.mutate()
                    .request(exchange
                            .getRequest()
                            .mutate()
                            .header("hello", "hello")
                            .build());
            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }

