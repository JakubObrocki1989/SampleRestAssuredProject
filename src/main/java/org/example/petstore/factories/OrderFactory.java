package org.example.petstore.factories;

import lombok.SneakyThrows;
import org.example.core.base.BaseFactory;
import org.example.petstore.api.models.Order;
import org.example.petstore.enums.OrderStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static org.example.petstore.enums.OrderStatus.PLACED;

public class OrderFactory extends BaseFactory {

    @SneakyThrows
    public Order getRandomOrder() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        Order.OrderBuilder order = Order.builder();
        order
                .id(faker.number().numberBetween(0,10000))
                .petId(faker.number().numberBetween(0,10000))
                .quantity(faker.number().numberBetween(0,10))
                .shipDate(nowAsISO)
                .status(String.valueOf(OrderStatus.values()[rand.nextInt(OrderStatus.values().length)]))
                .complete(faker.bool().bool());
        return order.build();
    }

}
