package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "sisters", layout = MainView.class)
public class SistersView extends VerticalLayout {

    public SistersView() {
        add(new Label("This is the Sisters View"));
    }

}
