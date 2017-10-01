package com.example.clase_vaadin;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class Formulario extends FormLayout{

	FormLayout form = new FormLayout();
	
	public Formulario(){ 
		
		TextField tf1 = new TextField("Name");
		tf1.setIcon(FontAwesome.USER);
		tf1.setRequired(true);
		tf1.addValidator(new com.vaadin.data.validator.NullValidator("Must be given", false));
		form.addComponent(tf1);
		
		TextField tf2 = new TextField("Street");
		tf1.setIcon(FontAwesome.ROAD);
		form.addComponent(tf2);
	}
	
	public FormLayout getForm(){
		return form;
	}
}
