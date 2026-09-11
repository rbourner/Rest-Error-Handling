package com.acme;

import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.kogito.internal.process.event.DefaultKogitoProcessEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomProcessEventListener extends DefaultKogitoProcessEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomProcessEventListener.class);
    private static final String PREFIX = ">>>>> [PROCESS-LISTENER] ";

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        LOGGER.info(PREFIX + "beforeProcessStarted: processId={}",
                event.getProcessInstance().getProcessId());
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        LOGGER.info(PREFIX + "beforeProcessCompleted: processId={}",
                event.getProcessInstance().getProcessId());
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        LOGGER.info(PREFIX + "beforeNodeTriggered: nodeName={}",
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        LOGGER.info(PREFIX + "beforeNodeLeft: nodeName={}",
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        LOGGER.info(PREFIX + "beforeVariableChanged: variableId={}, OLD_VALUE={}, NEW_VALUE={}",
                event.getVariableId(),
                event.getOldValue(),
                event.getNewValue());
    }
}
