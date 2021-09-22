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
    }



    @Override
    public void localeChange(LocaleChangeEvent event) {
        this.getItems().forEach(i -> {
            i.setText(getTranslation(i.getId().get(), UI.getCurrent().getLocale()));
        });
    }
}
