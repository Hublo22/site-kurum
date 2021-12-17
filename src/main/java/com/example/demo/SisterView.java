package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
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

    Html html;

    @Autowired
    ResourceLoader resourceLoader;

    public SisterView() {
        desc = new Label(getTranslation("sister.desc", UI.getCurrent().getLocale()));
        String content = "<text></text>";
        html = new Html(content);
        setAlignItems(Alignment.CENTER);

        Image sisterImg = new Image("img/sisterKurum.jpg", "Sister Kurumbagaram");
        sisterImg.setMaxWidth("1000px");

        add(desc);
        add(sisterImg);
        add(html);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        desc.setText(getTranslation("sister.desc", UI.getCurrent().getLocale()));
        remove(html);
        String content = Utils.loadContentFor(resourceLoader,"sister");
        html = new Html("<text>" + content + "</text>");
        add(html);
    }
}
