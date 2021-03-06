// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.packtpub.springsecurity.events.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationRequestFactory;
import com.packtpub.springsecurity.events.client.managed.ui.EventDetailsView;
import com.packtpub.springsecurity.events.client.managed.ui.EventEditView;
import com.packtpub.springsecurity.events.client.managed.ui.EventListView;
import com.packtpub.springsecurity.events.client.managed.ui.EventMobileDetailsView;
import com.packtpub.springsecurity.events.client.managed.ui.EventMobileEditView;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.request.EventRequest;
import com.packtpub.springsecurity.events.client.scaffold.ScaffoldApp;
import com.packtpub.springsecurity.events.client.scaffold.place.CreateAndEditProxy;
import com.packtpub.springsecurity.events.client.scaffold.place.FindAndEditProxy;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyPlace;

public abstract class EventActivitiesMapper_Roo_Gwt {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    protected Activity makeCreateActivity() {
        EventEditView.instance().setCreating(true);
        final EventRequest request = requests.eventRequest();
        Activity activity = new CreateAndEditProxy<EventProxy>(EventProxy.class, request, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(EventProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new EventEditActivityWrapper(requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), activity, null);
    }

    @SuppressWarnings("unchecked")
    protected EntityProxyId<com.packtpub.springsecurity.events.client.proxy.EventProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<EventProxy>) place.getProxyId();
    }

    protected Activity makeEditActivity(ProxyPlace place) {
        EventEditView.instance().setCreating(false);
        EntityProxyId<EventProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<EventProxy>(proxyId, requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(EventProxy proxy) {
                EventRequest request = requests.eventRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new EventEditActivityWrapper(requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), activity, proxyId);
    }
}
