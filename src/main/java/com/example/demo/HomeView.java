package com.example.demo;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
public class HomeView extends VerticalLayout {

    public HomeView() {

        Image img = new Image("img/kurumLocation.png", "Kurum location");
        img.setMaxWidth("1000px");

        add(img);
        setAlignItems(Alignment.CENTER);
    }

}
