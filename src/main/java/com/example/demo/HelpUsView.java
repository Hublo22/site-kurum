package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "helpus", layout = MainView.class)
public class HelpUsView extends VerticalLayout {

    public HelpUsView() {
        add(new Label("This is the HelpUs View"));
    }

}
