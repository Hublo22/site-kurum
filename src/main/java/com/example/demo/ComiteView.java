package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

@Route(value = "comite", layout = MainView.class)
public class ComiteView extends VerticalLayout implements LocaleChangeObserver {

    Html html;

    @Autowired
    ResourceLoader resourceLoader;

    public ComiteView() {
        String content = getTranslation("comite.content", UI.getCurrent().getLocale());
        html = new Html("<text>" + content + "</text>");
        add(html);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        remove(html);
        String content = loadContentFor();
        html = new Html("<text>" + content + "</text>");
        add(html);
    }

    private String loadContentFor() {
        String result = "NO TRANSLATION TEMPLATE FILE FOUND";
        try {
            if(UI.getCurrent().getLocale().equals(Locale.FRENCH)) {
                Resource template = resourceLoader.getResource("classpath:comite_fr.template");
                result = IOUtils.toString(template.getInputStream(),"UTF-8");
//                result = FileUtils .readFileToString(template, "UTF-8");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return result;
    }
}
