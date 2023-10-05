package com.example.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "conte", layout = MainView.class)
public class Conte extends Div {

    public Conte() {
        add(new EmbeddedPdfDocument("pdf/flyerConte.pdf"));
        setSizeFull();
    }

}
