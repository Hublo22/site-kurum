package com.example.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "pvAg2022", layout = MainView.class)
public class PvAg2022 extends Div {

    public PvAg2022() {
        add(new EmbeddedPdfDocument("pdf/pvAg2022.pdf"));
        setSizeFull();
    }

}
