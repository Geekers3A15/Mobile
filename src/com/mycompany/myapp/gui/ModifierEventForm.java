/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceEvenement;

/**
 *
 * @author USER
 */
public class ModifierEventForm extends BaseForm {

    public ModifierEventForm(int idUser, Form previous, evenement e, String role) {
        super("Modifier evenement", BoxLayout.y());
        getContentPane().setScrollVisible(false);

        String nbmaxS = String.valueOf(e.getNb_max());

        String prixS = String.valueOf(e.getNb_max());

        TextField titre = new TextField(e.getTitre_event(), "titre", 20, TextField.ANY);
        titre.setUIID("TextFieldBack");

        TextField image = new TextField(e.getImage_event(), "image", 20, TextField.ANY);
        image.setUIID("TextFieldBack");

        ComboBox categorie = new ComboBox();
        categorie.addItem("Photography");
        categorie.addItem("Design");
        categorie.addItem("Music");
        categorie.setUIID("TextFieldBack");

        TextField description = new TextField(e.getDescription(), "description", 20, TextField.ANY);
        description.setUIID("TextFieldBack");

        TextField dateDeb = new TextField(e.getDate_deb(), "date debut", 20, TextField.ANY);
        dateDeb.setUIID("TextFieldBack");

        TextField dateFin = new TextField(e.getDate_fin(), "date fin", 20, TextField.ANY);
        dateFin.setUIID("TextFieldBack");

        TextField location = new TextField(e.getLocation(), "localisation", 20, TextField.ANY);
        location.setUIID("TextFieldBack");

        TextField nbMax = new TextField(nbmaxS, "nombre max", 11, TextField.NUMERIC);
        nbMax.setUIID("TextFieldBack");

        TextField prix = new TextField(prixS, "prix", 11, TextField.NUMERIC);
        prix.setUIID("TextFieldBack");

        Button btnmodifier = new Button("Modifier");
        btnmodifier.addPointerPressedListener(m -> {
            e.setId_artiste(idUser);
            e.setTitre_event(titre.getText());
            e.setImage_event(image.getText());
            e.setCategorie(categorie.getSelectedItem().toString());
            e.setDescription(description.getText());
            e.setDate_deb(dateDeb.getText());
            e.setDate_fin(dateFin.getText());
            e.setLocation(location.getText());

            e.setNb_max(nbMax.getAsInt(BASELINE));
            e.setPrix(prix.getAsInt(BASELINE));

            System.out.println(e.toString());

            if (ServiceEvenement.getInstance().updateEvenement(e, idUser)) {

                new HomeForm(idUser,role).show();
            }

        });

        Button btnannuler = new Button("Annuler");
        btnannuler.addActionListener(a -> {
            new HomeForm(idUser,role).show();

        });
        Label l1 = new Label("Titre");
        Label l2 = new Label("Image");
        Label l3 = new Label("Categorie");
        Label l4 = new Label("description");
        Label l5 = new Label("Date début");
        Label l6 = new Label("Date fin");

        Label l9 = new Label("Localisation");
        Label l10 = new Label("nombre max");
        Label l11 = new Label("prix");
        Container content = BoxLayout.encloseY(
                l1,
                titre,
                l2,
                image,
                l3,
                categorie,
                l4,
                description,
                l5,
                dateDeb,
                l6,
                dateFin,
                l9,
                location,
                l10,
                nbMax,
                l11,
                prix,
                btnmodifier,
                btnannuler
        );
        
        add(content);
        show();

    }
}


