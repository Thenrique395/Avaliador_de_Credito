package com.estudo.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

@Bean
public RouteLocator router(RouteLocatorBuilder build){
	return  build.routes()
			.route(r-> r.path("/client/**").uri("lb://client"))
			.route(r-> r.path("/card/**").uri("lb://card"))
			.route(r-> r.path("/avaliator/**").uri("lb://avaliadorcredito"))

			.build();

}
}
