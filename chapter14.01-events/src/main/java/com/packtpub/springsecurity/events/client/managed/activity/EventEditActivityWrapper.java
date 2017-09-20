package com.packtpub.springsecurity.events.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationRequestFactory;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.scaffold.activity.IsScaffoldMobileActivity;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyEditView;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyListPlace;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EventEditActivityWrapper extends EventEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<EventProxy> proxyId;

    public EventEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<com.packtpub.springsecurity.events.client.proxy.EventProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(EventProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Event" : "Edit Event";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends com.packtpub.springsecurity.events.client.scaffold.place.ProxyEditView<com.packtpub.springsecurity.events.client.proxy.EventProxy, V>> extends ProxyEditView<EventProxy, V> {
    }
}
