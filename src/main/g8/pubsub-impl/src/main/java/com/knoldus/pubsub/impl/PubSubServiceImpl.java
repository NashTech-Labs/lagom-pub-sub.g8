package com.knoldus.pubsub.impl;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.knoldus.pubsub.api.PubSubService;
import com.knoldus.pubsub.model.Temperature;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.pubsub.PubSubRef;
import com.lightbend.lagom.javadsl.pubsub.PubSubRegistry;
import com.lightbend.lagom.javadsl.pubsub.TopicId;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class PubSubServiceImpl implements PubSubService {

    private final PubSubRegistry pubSub;

    @Inject
    public PubSubServiceImpl(PubSubRegistry pubSub) {
        this.pubSub = pubSub;
    }


    @Override
    public ServiceCall<Temperature, NotUsed> publishTemperature(String id) {
        return temperature -> {
            final PubSubRef<Temperature> topic =
                    pubSub.refFor(TopicId.of(Temperature.class, id));
            topic.publish(temperature);
            return CompletableFuture.completedFuture(NotUsed.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, Source<Temperature, ?>> subscribeTemperature(String id) {
        return request -> {
            final PubSubRef<Temperature> topic =
                    pubSub.refFor(TopicId.of(Temperature.class, id));
            return CompletableFuture.completedFuture(topic.subscriber());
        };
    }
}
