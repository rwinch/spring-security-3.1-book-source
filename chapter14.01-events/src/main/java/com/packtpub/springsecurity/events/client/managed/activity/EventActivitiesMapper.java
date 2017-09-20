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

public class EventActivitiesMapper extends EventActivitiesMapper_Roo_Gwt {

    public EventActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new EventDetailsActivity((EntityProxyId<EventProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? EventMobileDetailsView.instance() : EventDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
