package com.example.clase_vaadin.Pruebas.UI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class OtraView extends VerticalLayout implements View{
		

	public static final String NAME = "otraView";


	public OtraView(){
		setSizeFull();
		
		Button button = new Button("Ir a StartView2", new Button.ClickListener(){
			@Override
			public void buttonClick(ClickEvent event){
				getUI().getNavigator().navigateTo("");
			}
		});
		
		addComponent(button);
		setComponentAlignment(button, Alignment.BOTTOM_CENTER);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
