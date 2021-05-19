/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.entities.user;
import com.mycompany.myapp.services.ServiceEvenement;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ListeEventsForm extends BaseForm {

    Form current;

    public ListeEventsForm(Form previous, int idUser, String role) {
        setTitle("Liste Evenements");
        setLayout(BoxLayout.y());
       

        ArrayList<evenement> liste = ServiceEvenement.getInstance().affichageEvenement();

        for (evenement e : liste) {
            Button t = new Button(e.getTitre_event());

            add(t);

            createLineSeparator();

            t.addActionListener(d -> {

                new detailEventForm(previous, e.getId_event(), idUser, e, role).show();

            });
            TextField searchField;
            searchField = new TextField("", "recherche une événement");
            searchField.getHintLabel().setUIID("Title");
            searchField.setUIID("Title");
            getToolbar().setTitleComponent(searchField);

            searchField.addDataChangeListener((i1, i2) -> {
                String s = searchField.getText();
                if (s.length() < 1) {
                    for (Component cmp : getContentPane()) {
                        cmp.setHidden(false);
                        cmp.setVisible(true);
                    }

                } else {
                    s = s.toLowerCase();
                    for (Component cmp : getContentPane()) {
                       
                        String val = ((Button)((cmp))).getText();
                        System.out.println(val);
                        boolean show = val != null && val.toLowerCase().indexOf(s) > -1;
                        cmp.setHidden(!show);
                        cmp.setVisible(show);
                    }
                }
                });

            }

               getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                g -> previous.showBack()); // Revenir vers l'interface précédente
        }
    }
