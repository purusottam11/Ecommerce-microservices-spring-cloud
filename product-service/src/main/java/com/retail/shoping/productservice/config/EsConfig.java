package com.retail.shoping.productservice.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.retail.shoping.productservice.repository")
public class EsConfig {


}