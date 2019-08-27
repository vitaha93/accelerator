package com.introlabsystems.accelerator.client.rabbitmq;

public final class QueueConstants {
    public static final String FETCH_EXCHANGE = "fetch.exchange";
    public static final String FETCH_QUEUE = "fetch.queue";
    public static final String FETCH_ROUTING_KEY = "fetch.routing.key";

    private QueueConstants() {
        throw new UnsupportedOperationException("Constants class");
    }
}
