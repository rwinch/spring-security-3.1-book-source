// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package com.packtpub.springsecurity.events.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "com.packtpub.springsecurity.events.server.domain.Event", locator = "com.packtpub.springsecurity.events.server.locator.EventLocator")
@RooGwtProxy(value = "com.packtpub.springsecurity.events.server.domain.Event", readOnly = { "version", "id" }, scaffold = true)
public interface EventProxy extends EntityProxy {

    abstract Long getId();

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Integer getVersion();
}
