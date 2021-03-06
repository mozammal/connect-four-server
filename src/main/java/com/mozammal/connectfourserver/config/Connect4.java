package com.mozammal.connectfourserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "connect4")
public class Connect4 {

  private String app;

  private String broker;

  private String endpoint;

  private String frontendUrl;

  private String userPrefix;
}
