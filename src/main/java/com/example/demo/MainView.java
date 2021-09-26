package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import java.awt.*;

@CssImport("./styles/shared-styles.css")
public class MainView extends AppLayout implements RouterLayout {

    public MainView() {
        Label mainTitle = new Label("Association de solidarité Kurumbagaram");
        mainTitle.setId("mainTitle");

        HorizontalLayout line0 = new HorizontalLayout();
        HorizontalLayout line1 = new HorizontalLayout();


        line0.add(new LanguageList().getLanguageList());
        line0.setAlignItems(FlexComponent.Alignment.END);
        line0.setId("languageSelectorLayout");

        line1.add(mainTitle);


        HorizontalLayout line2 = new HorizontalLayout(new MainMenuBar());

        VerticalLayout vl = new VerticalLayout(line1,line2);
        vl.setAlignItems(FlexComponent.Alignment.CENTER);
        addToNavbar(vl,line0);

    }
}
