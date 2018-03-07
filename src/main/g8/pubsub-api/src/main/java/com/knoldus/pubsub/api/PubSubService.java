package com.knoldus.pubsub.api;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.knoldus.pubsub.model.Temperature;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;

public interface PubSubService extends Service {

    ServiceCall<Temperature, NotUsed> publishTemperature(String id);

    ServiceCall<NotUsed, Source<Temperature, ?>> subscribeTemperature(String id);

    @Override
    default Descriptor descriptor() {
        return named("pubsub").withCalls(
                Service.pathCall("/api/temperature/publish/:id", this::publishTemperature),
                Service.pathCall("/api/temperature/subscribe/:id", this::subscribeTemperature)
        ).withAutoAcl(true);
    }
}