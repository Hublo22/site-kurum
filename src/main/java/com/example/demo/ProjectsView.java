package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "projects", layout = MainView.class)
public class ProjectsView extends VerticalLayout {

    public ProjectsView() {
        add(new Label("This is the Project View"));
    }

}
