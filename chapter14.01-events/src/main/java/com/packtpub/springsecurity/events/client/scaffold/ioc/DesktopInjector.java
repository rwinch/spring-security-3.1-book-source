package com.packtpub.springsecurity.events.client.scaffold.ioc;

import com.packtpub.springsecurity.events.client.scaffold.ScaffoldDesktopApp;
import com.google.gwt.inject.client.GinModules;

@GinModules(value = {ScaffoldModule.class})
public interface DesktopInjector extends ScaffoldInjector {

	ScaffoldDesktopApp getScaffoldApp();
}