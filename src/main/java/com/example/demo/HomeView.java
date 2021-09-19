package com.example.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
public class HomeView extends VerticalLayout {

    public HomeView() {

        Label label = new Label("Le nouveau site sera en ligne très prochainement.");
        label.setClassName("tempMessage");
        add(label);
        Label label1 = new Label("The new Website will soon be online.");
        label1.setClassName("tempMessage");
        add(label1);
        Label label2 = new Label("Die neue Website wird bald online sein.");
        label2.setClassName("tempMessage");
        add(label2);

        setAlignItems(Alignment.CENTER);



    }

}
