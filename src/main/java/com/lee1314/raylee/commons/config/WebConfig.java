package com.lee1314.raylee.commons.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置HTTP与HTTPS
 * 
 * 加载config配置文件
 * 
 * @title WebConfig
 * @author 雷力
 * @date 2019年4月30日下午5:21:29
 *
 */
@Configuration
@PropertySource("classpath:/config.properties")
public class WebConfig {

	@Value("${http.port}")
	private Integer prot;

	@Bean
	public Connector connector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(prot);
		return connector;
	}

	@Bean
	public ServletWebServerFactory tomcatServletWebServerFactory(Connector connector) {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector()); // 添加http
		return tomcat;
	}

}
