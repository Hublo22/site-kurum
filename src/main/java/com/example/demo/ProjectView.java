package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;

@Route("projets")
public class ProjectView extends VerticalLayout implements LocaleChangeObserver {

    public ProjectView() {
        MyHtml html = new MyHtml(getTranslation("projets.content", UI.getCurrent().getLocale()));
        add(new MainMenuBar());
        add(html);
        add(new LanguageList().getLanguageList());
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        MyHtml html = (MyHtml) this.getComponentAt(1);
        html.setOuterHtml(getTranslation("projets.content", UI.getCurrent().getLocale()));
        //componentAt.getElement() .setProperty("innerHtml",getTranslation("projets.content", UI.getCurrent().getLocale()));
    }
}
