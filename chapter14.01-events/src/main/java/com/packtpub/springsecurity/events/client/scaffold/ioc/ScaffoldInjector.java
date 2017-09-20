package com.packtpub.springsecurity.events.client.scaffold.ioc;

import com.packtpub.springsecurity.events.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
