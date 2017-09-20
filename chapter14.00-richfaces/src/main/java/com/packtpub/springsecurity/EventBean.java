package com.packtpub.springsecurity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class EventBean implements Serializable {

    private static final long serialVersionUID = -6239437588285327644L;

    private String id;

    private EventService eventService;

    public EventBean() {
        System.out.println(new Date());
    }

    @PostConstruct
    public void postContruct() {
        id = "0";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return eventService == null ? null : eventService.getEvent(getId());
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}