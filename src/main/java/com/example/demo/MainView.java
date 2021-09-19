package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

@CssImport("./styles/shared-styles.css")
public class MainView extends AppLayout implements RouterLayout {

    public MainView() {
        Label mainTitle = new Label("Association de solidarité Kurumbagaram");
        mainTitle.setId("mainTitle");
        VerticalLayout vl = new VerticalLayout(mainTitle,new MainMenuBar(), new LanguageList().getLanguageList());
        vl.setAlignItems(FlexComponent.Alignment.CENTER);
        addToNavbar(vl);
    }
}
