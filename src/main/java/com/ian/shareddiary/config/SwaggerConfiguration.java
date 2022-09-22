package com.ian.shareddiary.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
			.group("ian")
			.pathsToMatch("/**")
			.build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
			.info(new Info().title("Shared Diary API")
				.description("공유일기 프로젝트 API 입니다.")
				.version("v0.0.1"));
	}
}
