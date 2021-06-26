package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "contact", layout = MainView.class)
public class ContactView extends VerticalLayout {

    public ContactView() {
        add(new Label("This is the contact view"));
    }
}
