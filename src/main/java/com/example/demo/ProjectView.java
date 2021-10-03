package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

@Route(value = "project", layout = MainView.class)
public class ProjectView extends VerticalLayout implements LocaleChangeObserver {

    Html html;

    @Autowired
    ResourceLoader resourceLoader;

    public ProjectView() {
        String content = "<text></text>";
        html = new Html(content);
        add(html);
        setAlignItems(Alignment.CENTER);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        remove(html);
        String content = Utils.loadContentFor(resourceLoader,"projects");
        html = new Html("<text>" + content + "</text>");
        add(html);
    }
}
