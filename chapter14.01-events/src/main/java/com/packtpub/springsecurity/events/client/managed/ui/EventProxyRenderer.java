package com.packtpub.springsecurity.events.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;

public class EventProxyRenderer extends ProxyRenderer<EventProxy> {

    private static com.packtpub.springsecurity.events.client.managed.ui.EventProxyRenderer INSTANCE;

    protected EventProxyRenderer() {
        super(new String[] { "description" });
    }

    public static com.packtpub.springsecurity.events.client.managed.ui.EventProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new EventProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(EventProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
