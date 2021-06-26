package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "history", layout = MainView.class)
public class HistoryView extends VerticalLayout {

    public HistoryView() {
        add(new Label("This is the history View"));
    }

}
