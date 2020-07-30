package com.mozammal.connectfourserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class WebConfig {

  private Connect4 properties;

  public WebConfig(Connect4 properties) {
    this.properties = properties;
  }

  @Bean
  public CorsFilter corsFilter() {

    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(Collections.singletonList(properties.getFrontendUrl()));
    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
    config.setAllowCredentials(true);
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
