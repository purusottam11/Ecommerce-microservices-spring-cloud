package com.retail.shoping.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.retail.shoping.orderservice.repository")
public class ESConfig {


}
