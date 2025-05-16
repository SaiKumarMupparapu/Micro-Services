package com.example.demo.filters;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.example.demo.jwt.JwtService;

import reactor.core.publisher.Mono;

@Component
public class MyApiGateWayFilter implements GlobalFilter {

	@Autowired
	private JwtService jwtService;
	private static final List<String> openPath=List.of("/auth/register","/auth/token","/auth/validate");
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String path = exchange.getRequest().getURI().getPath();
		
//		System.err.println(path);
		
		if(openPath.stream().anyMatch(path::startsWith)) {
			return chain.filter(exchange);
		}
		String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		String token=authHeader.substring(7);
		if(!jwtService.isTokenValid(token)) {
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}
