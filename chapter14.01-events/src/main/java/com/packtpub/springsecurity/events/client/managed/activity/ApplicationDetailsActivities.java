package com.packtpub.springsecurity.events.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationEntityTypesProcessor;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationRequestFactory;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyPlace;

public class ApplicationDetailsActivities extends ApplicationDetailsActivities_Roo_Gwt {

    @Inject
    public ApplicationDetailsActivities(ApplicationRequestFactory requestFactory, PlaceController placeController) {
        this.requests = requestFactory;
        this.placeController = placeController;
    }
}
