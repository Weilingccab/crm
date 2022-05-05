package com.javaDemo.crm.config;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String SWAGGER_PACKAGE = "com.javaDemo";
	

	@Bean
	public Docket creatBasicImportRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("範例")
				.apiInfo(apiInfo("CRM API 範例 ", "", "")).select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_PACKAGE))// api接口包扫描路径
				.paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
				.build();
	}

	
	private ApiInfo apiInfo(String title, String description, String modelName) {
		/*抓取系統版本號及模組版本號*/
		String systemVersion = "v1";
		String version = "v1";

		return new ApiInfoBuilder().title(title)// 设置文档的标题
				.description(description)// 设置文档的描述->1.Overview
				.version(version)// 设置文档的版本信息-> 1.1 Version information.
				.license("系統版本號" + systemVersion).build();
	}

}

