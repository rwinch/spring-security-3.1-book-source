package com.packtpub.springsecurity.events.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationRequestFactory;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.scaffold.ScaffoldMobileApp;
import com.packtpub.springsecurity.events.client.scaffold.activity.IsScaffoldMobileActivity;
import com.packtpub.springsecurity.events.client.scaffold.place.AbstractProxyListActivity;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyListView;
import java.util.List;

public class EventListActivity extends EventListActivity_Roo_Gwt {

    public EventListActivity(ApplicationRequestFactory requests, ProxyListView<com.packtpub.springsecurity.events.client.proxy.EventProxy> view, PlaceController placeController) {
        super(placeController, view, EventProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Events";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<com.packtpub.springsecurity.events.client.proxy.EventProxy>> createRangeRequest(Range range) {
        return requests.eventRequest().findEventEntries(range.getStart(), range.getLength());
    }
}
