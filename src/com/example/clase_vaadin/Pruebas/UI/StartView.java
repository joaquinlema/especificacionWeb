package com.example.clase_vaadin.Pruebas.UI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class StartView extends VerticalLayout implements View {

	public StartView(){
		setSizeFull();
		
		Button button = new Button("Ir a Main", new Button.ClickListener(){
			@Override
			public void buttonClick(ClickEvent event){
				getUI().getNavigator().navigateTo("otraView");
			}
		});
		
		addComponent(button);
		setComponentAlignment(button, Alignment.BOTTOM_LEFT);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

	
}
