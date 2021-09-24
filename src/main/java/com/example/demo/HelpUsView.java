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


@Route(value = "helpus", layout = MainView.class)
public class HelpUsView extends VerticalLayout implements LocaleChangeObserver {

    Label intro;

    public HelpUsView() {

        intro = new Label(getTranslation("helpus.intro", UI.getCurrent().getLocale()));
        RadioButtonGroup<String> gender = new RadioButtonGroup<>();
        gender.setItems("Madame", "Monsieur");
        gender.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        TextField firstName = new TextField("Nom");
        firstName.setRequired(true);
        TextField lastName = new TextField("Prénom");
        TextField address = new TextField("Adresse");
        NumberField postalCode = new NumberField("Code postal");
        TextField city = new TextField("Localité");
        EmailField email = new EmailField("Email");
        NumberField phone = new NumberField("Téléphone");
        Checkbox becomeMember = new Checkbox("Je souhaite devenir membre");
        Checkbox wantInfoForEducationProgram = new Checkbox("Je souhaite des informations pour le soutien d'une orpheline");
        Button send = new Button("Envoyer");

        HorizontalLayout line1 = new HorizontalLayout(gender);
        HorizontalLayout line2 = new HorizontalLayout(firstName,lastName);
        HorizontalLayout line3 = new HorizontalLayout(postalCode,address,city);
        HorizontalLayout line4 = new HorizontalLayout(email,phone);

        add(intro,line1,line2,line3,line4,becomeMember,wantInfoForEducationProgram,send);
        setAlignItems(Alignment.CENTER);

    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        intro.setText(getTranslation("helpus.intro", UI.getCurrent().getLocale()));
    }
}
