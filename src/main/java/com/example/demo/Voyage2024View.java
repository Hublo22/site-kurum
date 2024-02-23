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


        Image f1 = new Image("img/voyage2024/f1.JPG", "f");
        f1.setMaxWidth("500px");
        Image f2 = new Image("img/voyage2024/f2.JPG", "f");
        f2.setMaxWidth("500px");
        Image f3 = new Image("img/voyage2024/f3.JPG", "f");
        f3.setMaxWidth("500px");
        Image f4 = new Image("img/voyage2024/f4.JPG", "f");
        f4.setMaxWidth("500px");
        Image f5 = new Image("img/voyage2024/f5.JPG", "f");
        f5.setMaxWidth("500px");
        Image f6 = new Image("img/voyage2024/f6.JPG", "f");
        f6.setMaxWidth("500px");
        Image f7 = new Image("img/voyage2024/f7.JPG", "f");
        f7.setMaxWidth("500px");
        Image f8 = new Image("img/voyage2024/f8.JPG", "f");
        f8.setMaxWidth("500px");
        Image f9 = new Image("img/voyage2024/f9.JPG", "f");
        f9.setMaxWidth("500px");
        Image f10 = new Image("img/voyage2024/f10.JPG", "f");
        f10.setMaxWidth("500px");
        Image f11 = new Image("img/voyage2024/f11.JPG", "f");
        f11.setMaxWidth("500px");
        Image f12 = new Image("img/voyage2024/f12.JPG", "f");
        f12.setMaxWidth("500px");
        Image f13 = new Image("img/voyage2024/f13.JPG", "f");
        f13.setMaxWidth("500px");
        Image f14 = new Image("img/voyage2024/f14.JPG", "f");
        f14.setMaxWidth("500px");
        Image f15 = new Image("img/voyage2024/f15.JPG", "f");
        f15.setMaxWidth("500px");
        Image f16 = new Image("img/voyage2024/f16.JPG", "f");
        f16.setMaxWidth("500px");
        Image f17 = new Image("img/voyage2024/f17.JPG", "f");
        f17.setMaxWidth("500px");
        Image f18 = new Image("img/voyage2024/f18.JPG", "f");
        f18.setMaxWidth("500px");
        Image f19 = new Image("img/voyage2024/f19.JPG", "f");
        f19.setMaxWidth("500px");
        Image f20 = new Image("img/voyage2024/f20.JPG", "f");
        f20.setMaxWidth("500px");
        Image f21 = new Image("img/voyage2024/f21.JPG", "f");
        f21.setMaxWidth("500px");

        HorizontalLayout hf1 = new HorizontalLayout(new Label("22.02.2024: Quelques image de Kurum"));
        HorizontalLayout hf2 = new HorizontalLayout(f1,f2,f3);
        HorizontalLayout hf3 = new HorizontalLayout(f4,f5,f6);
        HorizontalLayout hf4 = new HorizontalLayout(f7,f8,f9);
        HorizontalLayout hf5 = new HorizontalLayout(f10,f11,f12);
        HorizontalLayout hf6 = new HorizontalLayout(f13,f14,f15);
        HorizontalLayout hf7 = new HorizontalLayout(f16,f17,f18);
        HorizontalLayout hf8 = new HorizontalLayout(f19,f20,f21);




        HorizontalLayout line00 = new HorizontalLayout(a);
        HorizontalLayout line0 = new HorizontalLayout(new Label("20.02.2024: Quelques images de l'orphelinat ainsi que de Syria."));
        HorizontalLayout line01 = new HorizontalLayout(k1,k2,k3);
        HorizontalLayout line02 = new HorizontalLayout(k4,k5,k6);
        HorizontalLayout line03 = new HorizontalLayout(k7);
        HorizontalLayout line1 = new HorizontalLayout(new Label("18.02.2024: Sur la route pour Kurumbagaram, et arrivée sur place."));
        HorizontalLayout line2 = new HorizontalLayout(avion,avion2,avion3);
        HorizontalLayout line3 = new HorizontalLayout(enfant,mabalipuram,picnic);
        HorizontalLayout line4 = new HorizontalLayout(kurum,kurum2);
        add(hf1,hf2,hf3,hf4,hf5,hf6,hf7,hf8,line00,line0,line01,line02,line03,line1,line2,line3,line4);
    }
}
