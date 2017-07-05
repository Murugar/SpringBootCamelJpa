package com.iqmsoft.spring.boot.camel.jpa;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig extends SpringBootServletInitializer {

 
    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/SpringBootCamelJpa/*");
        servlet.setName("CamelServlet");
        return servlet;
    }
   
}
