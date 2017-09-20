package com.packtpub.springsecurity.events.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.packtpub.springsecurity.events.client.managed.request.ApplicationRequestFactory;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.scaffold.activity.IsScaffoldMobileActivity;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyDetailsView;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyListPlace;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyPlace;
import com.packtpub.springsecurity.events.client.scaffold.place.ProxyPlace.Operation;
import java.util.Set;

public class EventDetailsActivity extends EventDetailsActivity_Roo_Gwt {

    public EventDetailsActivity(EntityProxyId<com.packtpub.springsecurity.events.client.proxy.EventProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<com.packtpub.springsecurity.events.client.proxy.EventProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(EventProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Event";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((EventProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
