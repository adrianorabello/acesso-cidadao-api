package com.bi.biproxyapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;



@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	
  @Autowired
  private File file;

  @Override
  public void customize(ConfigurableWebServerFactory factory) {     
	  factory.setPort(Integer.parseInt(file.getJson().getPorta()));
  }
}
