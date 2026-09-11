package com.acme;

import org.kie.kogito.process.impl.DefaultWorkItemHandlerConfig;

import org.springframework.stereotype.Component;

@Component
public class CustomWorkItemHandlerConfig extends DefaultWorkItemHandlerConfig {

    {
        register("CustomTask", new CustomTaskWorkItemHandler());
    }
}
