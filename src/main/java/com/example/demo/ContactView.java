package com.example.demo;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Route(value = "contactAndInfo", layout = MainView.class)
public class ContactView extends VerticalLayout implements LocaleChangeObserver {

    @Autowired
    ResourceLoader resourceLoader;

    Html html;
    RadioButtonGroup<String> gender;
    TextField firstName;
    TextField lastName;
    TextField address;
    NumberField postalCode;
    TextField city;
    EmailField email;
    NumberField phone;
    Button send;
    Label confirmation;
    HorizontalLayout line1,line2,line3,line4;

    public ContactView() {
        html = new Html("<text></text>");

        gender = new RadioButtonGroup<>();
        gender.setItems(getTranslation("contact.miss",local()), getTranslation("contact.sir",local()));
        gender.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        gender.setRequired(true);

        firstName = new TextField(getTranslation("contact.firstName",local()));
        firstName.setRequired(true);

        lastName = new TextField(getTranslation("contact.lastName", local()));
        lastName.setRequired(true);

        address = new TextField(getTranslation("contact.address",local()));
        address.setRequired(true);

        postalCode = new NumberField(getTranslation("contact.nip",local()));
        postalCode.setRequiredIndicatorVisible(true);

        city = new TextField(getTranslation("contact.city",local()));
        city.setRequired(true);

        email = new EmailField("Email");
        email.setRequiredIndicatorVisible(false);

        phone = new NumberField(getTranslation("contact.phone",local()));

        send = new Button(getTranslation("contact.send",local()));
        send.addClickListener(event -> {
            onSend();
        });

        confirmation = new Label(getTranslation("contact.confirmation",local()));
        confirmation.setId("confirmation");
        confirmation.setVisible(false);

        line1 = new HorizontalLayout(gender);
        line2 = new HorizontalLayout(firstName,lastName);
        line3 = new HorizontalLayout(postalCode,address,city);
        line4 = new HorizontalLayout(email,phone);

        add(html,line1,line2,line3,line4,send,confirmation);
        setAlignItems(Alignment.CENTER);
    }

    private void onSend() {
        String submittedDate = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        StringBuffer value = new StringBuffer("Forms submitted on " + submittedDate);
        value.append(System.getProperty("line.separator"));
        value.append("Gender :" + gender.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("First Name: " + firstName.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("Last Name: " + lastName.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("Adress : " + address.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("NIP : " + postalCode.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("City : " + city.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("Email : " + email.getValue());
        value.append(System.getProperty("line.separator"));
        value.append("Phone : " + phone.getValue());
        value.append(System.getProperty("line.separator"));
        try {
            FileUtils.writeStringToFile(new File("C:/temp/newContact-"+submittedDate), value.toString(),"UTF-8");
        } catch (IOException e) {
            confirmation.setVisible(false);
            e.printStackTrace();
        }
        confirmation.setVisible(true);
    }

    private Locale local() {
        return UI.getCurrent().getLocale();
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        remove(html,line1,line2,line3,line4,send,confirmation);
        String content = Utils.loadContentFor(resourceLoader,"contactAndInfo");
        html = new Html("<text>" + content + "</text>");


        gender.setItems(getTranslation("contact.miss",local()), getTranslation("contact.sir",local()));
        firstName.setLabel(getTranslation("contact.firstName",local()));
        lastName.setLabel(getTranslation("contact.lastName", local()));
        address.setLabel(getTranslation("contact.address",local()));
        postalCode.setLabel(getTranslation("contact.nip",local()));
        city.setLabel(getTranslation("contact.city",local()));
        phone.setLabel(getTranslation("contact.phone",local()));
        send.setText(getTranslation("contact.send",local()));
        confirmation.setText(getTranslation("contact.confirmation",local()));
        confirmation.setVisible(false);

        line1 = new HorizontalLayout(gender);
        line2 = new HorizontalLayout(firstName,lastName);
        line3 = new HorizontalLayout(postalCode,address,city);
        line4 = new HorizontalLayout(email,phone);

        add(html,line1,line2,line3,line4,send,confirmation);
    }
}
