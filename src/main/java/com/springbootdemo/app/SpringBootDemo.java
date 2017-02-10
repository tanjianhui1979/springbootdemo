package com.springbootdemo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath*:spring/*.xml"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.springbootdemo.**.*"})
public class SpringBootDemo implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootDemo.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(Integer.parseInt(System.getProperty("http.port")));
    }
}