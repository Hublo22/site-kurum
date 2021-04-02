package com.example.demo;

import com.vaadin.flow.i18n.I18NProvider;
import org.apache.commons.compress.utils.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class II18NProviderImpl implements I18NProvider {

    public static final String RESOURCE_BUNDLE_NAME = "vaadinapp";

    private static final ResourceBundle RESOURCE_BUNDLE_FR = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME , Locale.FRENCH);
    private static final ResourceBundle RESOURCE_BUNDLE_DE = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, Locale.GERMAN);
    private static final ResourceBundle RESOURCE_BUNDLE_EN = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, Locale.ENGLISH);;

    public II18NProviderImpl(){}

    @Override
    public List<Locale> getProvidedLocales() {
        List<Locale> locales = Lists.newArrayList();
        locales.add(Locale.FRENCH);
        locales.add(Locale.GERMAN);
        return locales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... var3) {
        System.out.println("Within " + this.getClass().getSimpleName() + " , getting translation for " + key);
        ResourceBundle resourceBundle = RESOURCE_BUNDLE_FR;
        if (Locale.GERMAN.equals(locale)) {
            resourceBundle = RESOURCE_BUNDLE_DE;
        }
        if (Locale.ENGLISH.equals(locale)) {
            resourceBundle = RESOURCE_BUNDLE_EN;
        }

        if (! resourceBundle.containsKey(key)) {
            return key + " - " + locale;
        } else {
            return (resourceBundle.containsKey(key)) ? resourceBundle.getString(key) : key;
        }
    }
}
