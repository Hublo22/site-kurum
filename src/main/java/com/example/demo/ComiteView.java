package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "comite", layout = MainView.class)
public class ComiteView extends VerticalLayout {

    public ComiteView() {
        add(new Label("This is the comite View"));
    }

}
