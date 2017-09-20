package com.packtpub.springsecurity.events.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.packtpub.springsecurity.events.server.domain.Event;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("com.packtpub.springsecurity.events.server.domain.Event")
@Component
public class EventLocator extends Locator<Event, Long> {

    public Event create(Class<? extends com.packtpub.springsecurity.events.server.domain.Event> clazz) {
        return new Event();
    }

    public Event find(Class<? extends com.packtpub.springsecurity.events.server.domain.Event> clazz, Long id) {
        return Event.findEvent(id);
    }

    public Class<com.packtpub.springsecurity.events.server.domain.Event> getDomainType() {
        return Event.class;
    }

    public Long getId(Event event) {
        return event.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Event event) {
        return event.getVersion();
    }
}
