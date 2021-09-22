package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

@Route(value = "presentation", layout = MainView.class)
public class PresentationView extends VerticalLayout implements LocaleChangeObserver {

    Html html;

    @Autowired
    ResourceLoader resourceLoader;

    public PresentationView() {
        String content = "<text></text>";
        html = new Html(content);
        add(html);
        setAlignItems(Alignment.CENTER);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        remove(html);
        String content = Utils.loadContentFor(resourceLoader,"presentation");
        html = new Html("<text>" + content + "</text>");
        add(html);
    }
}
