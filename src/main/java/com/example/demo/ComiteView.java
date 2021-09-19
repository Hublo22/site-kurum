package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route(value = "comite", layout = MainView.class)
public class ComiteView extends VerticalLayout {

    public ComiteView() {

        TextArea ta = new TextArea();

        add(new Span("<p>test avec <h1>un objet</h1> html</p>"));
        Label label = new Label();
        label.getElement().setProperty("innerHtml","<p>test avec <h1>un objet</h1> html</p>");
        add(label);

        String yourContent ="A <h1>new line</h1> should be created after this <br /> <b>This text is bold</b> <br /> <i> This text is italic</i>";
        Html html = new Html("<text>" + yourContent + "</text>");
        add(html);
    }

}
