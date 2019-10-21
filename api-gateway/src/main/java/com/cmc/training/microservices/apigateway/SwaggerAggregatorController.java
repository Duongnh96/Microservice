package com.cmc.training.microservices.apigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerAggregatorController implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName("currency-exchange-service");
		swaggerResource.setLocation("/currency/v2/api-docs");
		swaggerResource.setSwaggerVersion("2.0");

		resources.add(swaggerResource);
		return resources;
	}

}
