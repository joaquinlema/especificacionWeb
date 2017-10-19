package com.example.clase_vaadin.Pruebas.UI;


import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

@Theme("valo")
@SuppressWarnings("serial")
public class WindowInicio extends UI{
	
	Navigator nav;
	private Tree tree;
	private Panel contenedor;
	private HorizontalSplitPanel hsplit;
	
	public static final String MAINVIEW = "main";
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WindowInicio.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("Ejemplo vaadin");
		
//		final TextField name = new TextField();
//		name.setCaption("Esto es un textField");
//		
//		Button btn = new Button("Boton");
//		btn.addClickListener(e -> {
//			layout.addComponent(new Label("thanks " + name.getValue()));
//		});
//		layout.addComponents(name,btn);
		
		tree = new Tree("Mi Aplicacion");	
		tree.addItem("Clientes");
		tree.addItem("Actualizar");
		tree.addItem("Borrar");
		tree.addItem("Reglas Negocio");
		tree.addItem("Impositivas");
		tree.addItem("Contables");
		tree.addItem("Otras");
		tree.addItem("Varias");
		
		tree.setParent("Actualizar", "Clientes");
		tree.setParent("Borrar", "Clientes");
		tree.setParent("Impositivas", "Reglas Negocio");
		tree.setParent("Contables", "Reglas Negocio");
		tree.setParent("Varias", "Otras");
		
		tree.setChildrenAllowed("Actualizar", false);
		tree.setChildrenAllowed("Borrar", false);
		tree.setChildrenAllowed("Impositivas", false);
		tree.setChildrenAllowed("Contables", false);
		tree.setChildrenAllowed("Varias", false);
		
		tree.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				getNavigator().navigateTo("otraView");
			}
		});
	
		contenedor = new Panel();
		contenedor.setSizeFull();
		
		nav = new Navigator(this, contenedor);
		
		nav.addView("", new StartView());
		nav.addView(OtraView.NAME, new OtraView());
		

		hsplit = new HorizontalSplitPanel();
		hsplit.setFirstComponent(tree);
		hsplit.setSecondComponent(contenedor);
		
		hsplit.setSplitPosition(30,Unit.PERCENTAGE);
		setContent(hsplit);
	}
	
	
}
