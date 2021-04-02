package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;

@Route("comite")
public class ComiteeView extends VerticalLayout implements LocaleChangeObserver  {

    public ComiteeView() {

        Label l = new Label();
        l.setId("comite.content");
        l.setText(getTranslation(l.getId().get(), UI.getCurrent().getLocale()));


        Text t = new Text(ElementFactory.createHeading1(getTranslation(l.getId().get(), UI.getCurrent().getLocale())).getText());

        Span s = new Span();
        s.getElement().setProperty("innerHTML",getTranslation(l.getId().get(), UI.getCurrent().getLocale()));

        Image pict = new Image();
        pict.setSrc("img/testPict.jpg");

        add(new MainMenuBar());
        add(l);
        add(t);
        add(s);
        add(pict);
        add(new LanguageList().getLanguageList());

    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        Label componentAt = (Label) this.getComponentAt(1);
        componentAt.setText(getTranslation(componentAt.getId().get(), UI.getCurrent().getLocale()));
        Text t = (Text) this.getComponentAt(2);
        t.setText(ElementFactory.createHeading1(getTranslation(componentAt.getId().get(), UI.getCurrent().getLocale())).getText());
        Span s = (Span) this.getComponentAt(3);
        s.getElement().setProperty("innerHTML",getTranslation(componentAt.getId().get(), UI.getCurrent().getLocale()));
    }
}
