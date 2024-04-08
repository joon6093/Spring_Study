package com.sjy.apigatewayservice.config;

import com.sjy.apigatewayservice.filter.CustomFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@RequiredArgsConstructor
public class FilterConfig {
    private final CustomFilter customFilter;
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//            .route(r -> r.path("/first-service/**")
//                .filters(f -> f.filter(customFilter.apply(new CustomFilter.Config()))
//                        .addRequestHeader("first-request", "first-request-header-by-java")
//                        .addResponseHeader("first-response", "first-response-header-by-java"))
//                .uri("http://127.0.0.1:8081"))
//            .route(r -> r.path("/second-service/**")
//                .filters(f -> f.filter(customFilter.apply(new CustomFilter.Config()))
//                        .addRequestHeader("second-request", "second-request-header-by-java")
//                        .addResponseHeader("second-response", "second-response-header-by-java"))
//                .uri("http://127.0.0.1:8082"))
//            .build();
//    }
}
