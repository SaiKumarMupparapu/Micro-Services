package com.example.demo.filters;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyApiGateWayFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Filters executing....");
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
//		Set<String> keySet = headers.keySet();
//		keySet.forEach(
//				a->System.out.println(headers.get(a)));
//		
		if(!headers.containsKey("token")) {
			throw new RuntimeException("Invalid token");
		}
		if(!headers.containsValue("abc")) {
			throw new RuntimeException("Invalid Authorization");
		}
		
		return chain.filter(exchange);
	}

}
