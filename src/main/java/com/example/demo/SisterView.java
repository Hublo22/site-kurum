package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

@Route(value = "sisters", layout = MainView.class)
public class SisterView extends VerticalLayout implements LocaleChangeObserver {

    Label desc;

    @Autowired
    ResourceLoader resourceLoader;

    public SisterView() {
        desc = new Label(getTranslation("sister.desc", UI.getCurrent().getLocale()));

        setAlignItems(Alignment.CENTER);
        add(desc);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        desc.setText(getTranslation("sister.desc", UI.getCurrent().getLocale()));
    }
}
