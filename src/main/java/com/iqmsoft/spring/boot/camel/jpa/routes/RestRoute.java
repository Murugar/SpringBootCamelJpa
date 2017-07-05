package com.iqmsoft.spring.boot.camel.jpa.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.iqmsoft.spring.boot.camel.jpa.service.Common;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
            .contextPath("/SpringBootCamelJpa").apiContextPath("/api-doc")
                .apiProperty("api.title", "Spring Boot Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
            .bindingMode(RestBindingMode.json);

        rest("/books").description("Books REST service")
            .get("/").description("The list of all the books")
                .route().routeId("books-api")
                .bean(Common.class, "findBooks")
                .endRest()
            .get("order/{id}").description("Details of an order by id")
                .route().routeId("order-api")
                .bean(Common.class, "findOrder(${header.id})");
    }
}
