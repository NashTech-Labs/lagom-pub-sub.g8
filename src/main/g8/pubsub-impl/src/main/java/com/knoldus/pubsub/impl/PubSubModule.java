package com.knoldus.pubsub.impl;

import com.google.inject.AbstractModule;
import com.knoldus.pubsub.api.PubSubService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class PubSubModule extends AbstractModule implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindService(PubSubService.class, PubSubServiceImpl.class);
    }
}
