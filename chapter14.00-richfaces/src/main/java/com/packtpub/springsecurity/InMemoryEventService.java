package com.packtpub.springsecurity;

import java.util.Map;

public class InMemoryEventService implements EventService {
    private final Map<String,String> eventIdToEvent;

    public InMemoryEventService(Map<String, String> eventIdToEvent) {
        this.eventIdToEvent = eventIdToEvent;
    }

    public String getEvent(String id) {
        return eventIdToEvent.get(id);
    }
}
