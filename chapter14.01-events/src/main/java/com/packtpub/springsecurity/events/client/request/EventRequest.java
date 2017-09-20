// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package com.packtpub.springsecurity.events.client.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;
import org.springframework.security.access.prepost.PreAuthorize;

@RooGwtRequest("com.packtpub.springsecurity.events.server.domain.Event")
@ServiceName("com.packtpub.springsecurity.events.server.domain.Event")
public interface EventRequest extends RequestContext {

    abstract Request<java.lang.Long> countEvents();

    abstract Request<java.util.List<com.packtpub.springsecurity.events.client.proxy.EventProxy>> findAllEvents();

    abstract Request<java.util.List<com.packtpub.springsecurity.events.client.proxy.EventProxy>> findEventEntries(int firstResult, int maxResults);

    abstract Request<com.packtpub.springsecurity.events.client.proxy.EventProxy> findEvent(Long id);

    abstract InstanceRequest<com.packtpub.springsecurity.events.client.proxy.EventProxy, java.lang.Void> persist();

    abstract InstanceRequest<com.packtpub.springsecurity.events.client.proxy.EventProxy, java.lang.Void> remove();
}
