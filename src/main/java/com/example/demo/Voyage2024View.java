package com.example.demo;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "voyage2024", layout = MainView.class)
public class Voyage2024View extends VerticalLayout {

    public Voyage2024View() {
        Image avion = new Image("img/voyage2024/avion.JPG", "Avion");
        avion.setMaxWidth("500px");
        Image avion2 = new Image("img/voyage2024/avion2.JPG", "Avion");
        avion2.setWidth("500px");
        Image avion3 = new Image("img/voyage2024/avion3.JPG", "Avion");
        avion3.setMaxWidth("500px");
        Image enfant = new Image("img/voyage2024/enfant.JPG", "Avion");
        enfant.setMaxWidth("500px");
        Image kurum = new Image("img/voyage2024/kurum.JPG", "Avion");
        kurum.setMaxWidth("500px");
        Image kurum2 = new Image("img/voyage2024/kurum2.JPG", "Avion");
        kurum2.setMaxWidth("500px");
        Image mabalipuram = new Image("img/voyage2024/mabalipuram.JPG", "Avion");
        mabalipuram.setMaxWidth("500px");
        Image picnic = new Image("img/voyage2024/picnic.JPG", "Avion");
        picnic.setMaxWidth("500px");

        Image k1 = new Image("img/voyage2024/k1.JPG", "Avion");
        k1.setMaxWidth("500px");
        Image k2 = new Image("img/voyage2024/k2.JPG", "Avion");
        k2.setMaxWidth("500px");
        Image k3 = new Image("img/voyage2024/k3.JPG", "Avion");
        k3.setMaxWidth("500px");
        Image k4 = new Image("img/voyage2024/k4.JPG", "Avion");
        k4.setMaxWidth("500px");
        Image k5 = new Image("img/voyage2024/k5.JPG", "Avion");
        k5.setMaxWidth("500px");
        Image k6 = new Image("img/voyage2024/k6.JPG", "Avion");
        k6.setMaxWidth("500px");
        Image k7 = new Image("img/voyage2024/k7.JPG", "Avion");
        k7.setMaxWidth("500px");

        Anchor a = new Anchor("https://youtu.be/RFb-FxBPaJE", "Vidéo faite par Jacques Kuenlin.");
        a.setTarget("_blank");
        HorizontalLayout line00 = new HorizontalLayout(a);
        HorizontalLayout line0 = new HorizontalLayout(new Label("20.02.2024: Quelques images de l'orphelinat ainsi que de Syria."));
        HorizontalLayout line01 = new HorizontalLayout(k1,k2,k3);
        HorizontalLayout line02 = new HorizontalLayout(k4,k5,k6);
        HorizontalLayout line03 = new HorizontalLayout(k7);
        HorizontalLayout line1 = new HorizontalLayout(new Label("18.02.2024: Sur la route pour Kurumbagaram, et arrivée sur place."));
        HorizontalLayout line2 = new HorizontalLayout(avion,avion2,avion3);
        HorizontalLayout line3 = new HorizontalLayout(enfant,mabalipuram,picnic);
        HorizontalLayout line4 = new HorizontalLayout(kurum,kurum2);
        add(line00,line0,line01,line02,line03,line1,line2,line3,line4);
    }
}
