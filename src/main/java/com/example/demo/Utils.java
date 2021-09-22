package com.example.demo;

import com.vaadin.flow.component.UI;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Locale;

public class Utils {

    private static String getTextFromResource(Resource r) throws IOException {
        return IOUtils.toString(r.getInputStream(),"UTF-8").replace(System.getProperty("line.separator"),"<br />");
    }

    public static String loadContentFor(ResourceLoader resourceLoader, String templateFileFirstPart) {
        String result = "NO TRANSLATION TEMPLATE FILE FOUND";
        try {
            if(UI.getCurrent().getLocale().equals(Locale.FRENCH)) {
                result = getTextFromResource(resourceLoader.getResource("classpath:" + templateFileFirstPart + "_fr.template"));
            }
            else if(UI.getCurrent().getLocale().equals(Locale.ENGLISH)) {
                result = getTextFromResource(resourceLoader.getResource("classpath:" + templateFileFirstPart + "_en.template"));
            }
            else if(UI.getCurrent().getLocale().equals(Locale.GERMAN)) {
                result = getTextFromResource(resourceLoader.getResource("classpath:" + templateFileFirstPart + "_de.template"));
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
        return result;
    }
}
