package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
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

import java.util.Locale;


@Route(value = "helpus", layout = MainView.class)
public class HelpUsView extends VerticalLayout implements LocaleChangeObserver {

    Label intro;
    RadioButtonGroup<String> gender;
    TextField firstName;
    TextField lastName;
    TextField address;
    NumberField postalCode;
    TextField city;
    EmailField email;
    NumberField phone;
    Checkbox becomeMember;
    Checkbox wantInfoForEducationProgram;
    Button send;

    public HelpUsView() {

        intro = new Label(getTranslation("helpus.intro", local()));

        gender = new RadioButtonGroup<>();
        gender.setItems(getTranslation("helpus.miss",local()), getTranslation("helpus.sir",local()));
        gender.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        gender.setRequired(true);

        firstName = new TextField(getTranslation("helpus.firstName",local()));
        firstName.setRequired(true);

        lastName = new TextField(getTranslation("helpus.lastName", local()));
        lastName.setRequired(true);

        address = new TextField(getTranslation("helpus.address",local()));
        address.setRequired(true);

        postalCode = new NumberField(getTranslation("helpus.nip",local()));
        postalCode.setRequiredIndicatorVisible(true);

        city = new TextField(getTranslation("helpus.city",local()));
        city.setRequired(true);

        email = new EmailField("Email");
        email.setRequiredIndicatorVisible(false);

        phone = new NumberField(getTranslation("helpus.phone",local()));

        becomeMember = new Checkbox(getTranslation("helpus.becomeMember",local()));

        wantInfoForEducationProgram = new Checkbox(getTranslation("helpus.infoForEducationProgram",local()));

        send = new Button(getTranslation("helpus.send",local()));

        HorizontalLayout line1 = new HorizontalLayout(gender);
        HorizontalLayout line2 = new HorizontalLayout(firstName,lastName);
        HorizontalLayout line3 = new HorizontalLayout(postalCode,address,city);
        HorizontalLayout line4 = new HorizontalLayout(email,phone);

        add(intro,line1,line2,line3,line4,becomeMember,wantInfoForEducationProgram,send);
        setAlignItems(Alignment.CENTER);

    }

    private Locale local() {
        return UI.getCurrent().getLocale();
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        intro.setText(getTranslation("helpus.intro", local()));
        gender.setItems(getTranslation("helpus.miss",local()), getTranslation("helpus.sir",local()));
        firstName.setLabel(getTranslation("helpus.firstName",local()));
        lastName.setLabel(getTranslation("helpus.lastName", local()));
        address.setLabel(getTranslation("helpus.address",local()));
        postalCode.setLabel(getTranslation("helpus.nip",local()));
        city.setLabel(getTranslation("helpus.city",local()));
        phone.setLabel(getTranslation("helpus.phone",local()));
        becomeMember.setLabel(getTranslation("helpus.becomeMember",local()));
        wantInfoForEducationProgram.setLabel(getTranslation("helpus.infoForEducationProgram",local()));
        send.setText(getTranslation("helpus.send",local()));
    }
}
