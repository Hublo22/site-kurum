package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.util.List;
import java.util.Locale;

@Route(value = "francisSelvadorayFoundation", layout = MainView.class)
public class FrancisSelvadorayFoundationView extends VerticalLayout implements LocaleChangeObserver {

    Html html;
    Grid<Orphans> grid;

    @Autowired
    ResourceLoader resourceLoader;

    public FrancisSelvadorayFoundationView() {
        String content = "<text></text>";
        html = new Html(content);
        //add(html);
        add(getOrphansGirlList());
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

    private Grid<Orphans> getOrphansGirlList() {
        grid = new Grid<>();
        grid.setItems(getOrphansList());
        grid.addColumn(Orphans::getName).setHeader(getTranslation("orphans.name",local()));
        grid.addColumn(Orphans::getFormation).setHeader(getTranslation("orphans.formation",local()));
        grid.addColumn(Orphans::getPathToPicture);
        grid.setSizeFull();
        grid.setVisible(true);
        return grid;
    }

    private List<Orphans> getOrphansList() {
        List<Orphans> l = Lists.newArrayList();
        l.add(new Orphans("Siria Pushpam","Enseignante", "pathToPicture"));
        return l;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        remove(html);
        remove (grid);
        String content = Utils.loadContentFor(resourceLoader,"francisSelvadorayFoundation");
        html = new Html("<text>" + content + "</text>");
        //add(html);
        add(getOrphansGirlList());
    }

    private Locale local() {
        return UI.getCurrent().getLocale();
    }

    private class Orphans {

        private String name;
        private String formation;
        private String pathToPicture;

        private Orphans(String name, String formation, String pathToPicture) {
            this.name = name;
            this.formation = formation;
            this.pathToPicture = pathToPicture;
        }

        public String getName() {
            return name;
        }

        public String getFormation() {
            return formation;
        }

        public String getPathToPicture() {
            return pathToPicture;
        }

    }
}
