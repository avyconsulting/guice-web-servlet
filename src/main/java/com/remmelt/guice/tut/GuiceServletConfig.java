package com.remmelt.guice.tut;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import javax.servlet.annotation.WebListener;

@WebListener
public class GuiceServletConfig extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				super.configureServlets();
				serve("/*").with(WiredServlet.class);
				bind(MessageSender.class).to(MessageSenderImpl.class);
			}
		});
	}
}
