package com.iqmsoft.spring.boot.camel.jpa.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServerRoute extends RouteBuilder {

    @Override
    public void configure() {
        // A first route generates some orders and queue them in DB
        from("timer:new-order?delay=2s&period={{example.generateOrderPeriod:2s}}")
            .routeId("generate-order")
            .bean("orderService", "generateOrder")
            .to("jpa:com.iqmsoft.spring.boot.camel.jpa.domain.Order")
            .log("Inserted new order ${body.id}");

        // A second route polls the DB for new orders and processes them
        from("jpa:com.iqmsoft.spring.boot.camel.jpa.domain.Order"
            + "?consumer.namedQuery=new-orders"
            + "&consumer.delay={{example.processOrderPeriod:4s}}"
            + "&consumeDelete=false")
            .routeId("process-order")
            .log("Processed order #id ${body.id} with ${body.amount} copies of the «${body.book.description}» book");
    }
}
