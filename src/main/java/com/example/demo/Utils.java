package com.example.demo;

import com.vaadin.flow.component.UI;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Utils {

    private static String getTextFromResource(Resource r) throws IOException {
        String result = "";
        String fileContent = IOUtils.toString(r.getInputStream(), "UTF-8");
        String[] split = fileContent.split(System.getProperty("line.separator"));
        List<String> contentAsList = Arrays.stream(split).collect(Collectors.toList());
        for(String s : contentAsList) {
            if(!s.endsWith("</li>") || s.endsWith("</h4>")) {
                result += s + "<br />";
            }
            else {
                result += s;
            }
        }
        return result;
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
