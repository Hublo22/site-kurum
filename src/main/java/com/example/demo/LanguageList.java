package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.server.VaadinSession;

import java.util.Locale;

public class LanguageList {

    public ComboBox<String> getLanguageList() {

        ComboBox<String> languages = new ComboBox<>();
        languages.setItems("FR","DE","EN");
        languages.setLabel("");

        languages.addValueChangeListener(change -> {
           Locale l;

           if(change.getValue().equalsIgnoreCase("de")) {
               l = Locale.GERMAN;
           }
           else if(change.getValue().equalsIgnoreCase("en")) {
               l = Locale.ENGLISH;
           }
           else {
               l = Locale.FRENCH;
           }

            System.out.println("Local changed with " + l.toString());

           UI.getCurrent().getSession().setLocale(l);

        });

        return languages;

    }

    /*
    private Select<Locale> buildLanguageSelection() {
        Select langSelect = new Select<>();
        langSelect.setEmptySelectionAllowed(false);
        langSelect.setRenderer(this.languageRenderer);
        langSelect.setItems(new Locale("de"), new Locale("fr"), new Locale("en"));
        langSelect.setValue(UI.getCurrent().getLocale());
        langSelect.addValueChangeListener(change -> UI.getCurrent().getSession().setLocale((Locale) change.getValue()));
        return langSelect;
    }

    private ComponentRenderer<HorizontalLayout, Locale> languageRenderer = new ComponentRenderer<>(item -> {
        HorizontalLayout hLayout = new HorizontalLayout();
        Image languageFlag = new Image("img/languageflags/"+item.getLanguage()+".png", "flag for "+item.getLanguage());
        languageFlag.setHeight("30px");
        hLayout.add(languageFlag);
        hLayout.add(new Span(getTranslation("LanguageSelection."+item.getLanguage())));
        hLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        return hLayout;
    });

     */
}
