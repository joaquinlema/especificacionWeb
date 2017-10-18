package com.example.clase_vaadin.Pruebas.UI;


import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
@SuppressWarnings("serial")
public class WindowInicio extends UI{
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WindowInicio.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("Ejemplo vaadin");
		
		final VerticalLayout layout = new VerticalLayout();
		
		final TextField name = new TextField();
		name.setCaption("Esto es un textField");
		
		Button btn = new Button("BOton");
		btn.addClickListener(e -> {
			layout.addComponent(new Label("thanks " + name.getValue()));
		});
		layout.addComponents(name,btn);
		
		setContent(layout);
	}
}
