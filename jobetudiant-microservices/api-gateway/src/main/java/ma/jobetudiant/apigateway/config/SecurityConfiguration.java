package ma.jobetudiant.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/eureka/**").permitAll()
                        .pathMatchers("/keycloak/**").permitAll()
                        .pathMatchers("/api/joboffers/**").permitAll()
                        .pathMatchers("/api/joboffers").permitAll()
                        .pathMatchers("/api/jobofferposting").permitAll()
                        .anyExchange().authenticated());

        serverHttpSecurity.oauth2ResourceServer(spec -> spec.jwt(Customizer.withDefaults()));


        serverHttpSecurity.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable);
        return serverHttpSecurity.build();
    }
}
