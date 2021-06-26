package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Component;

import java.util.Locale;

public class MainMenuBar extends MenuBar implements LocaleChangeObserver {


    public MainMenuBar() {
        super();


        MenuItem comite = addItem(getTranslation("comite", UI.getCurrent().getLocale()));
        comite.setId("comite");
        comite.addClickListener(e -> UI.getCurrent().navigate("comite"));

        MenuItem projects = addItem(getTranslation("projects", UI.getCurrent().getLocale()));
        projects.setId("projects");
        projects.addClickListener(e -> UI.getCurrent().navigate("projects"));

        MenuItem contact = addItem(getTranslation("contact", UI.getCurrent().getLocale()));
        contact.setId("contact");
        contact.addClickListener(e -> UI.getCurrent().navigate("contact"));

        MenuItem history = addItem(getTranslation("history", UI.getCurrent().getLocale()));
        history.setId("history");
        history.addClickListener(e -> UI.getCurrent().navigate("history"));

        MenuItem sisters = addItem(getTranslation("sisters", UI.getCurrent().getLocale()));
        sisters.setId("sisters");
        sisters.addClickListener(e -> UI.getCurrent().navigate("sisters"));

        MenuItem home = addItem(getTranslation("home", UI.getCurrent().getLocale()));
        home.setId("home");
        home.addClickListener(e -> UI.getCurrent().navigate(""));

        MenuItem helpus = addItem(getTranslation("helpus", UI.getCurrent().getLocale()));
        helpus.setId("helpus");
        helpus.addClickListener(e -> UI.getCurrent().navigate("helpus"));
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        this.getItems().forEach(i -> {
            i.setText(getTranslation(i.getId().get(), UI.getCurrent().getLocale()));
        });
    }
}
