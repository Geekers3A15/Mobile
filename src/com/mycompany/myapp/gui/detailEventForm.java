/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.entities.participation;
import com.mycompany.myapp.services.ServiceEvenement;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class detailEventForm extends BaseForm {

    Image img = null;
    ImageViewer iv = null;
    EncodedImage ec;
    Form current;

    public detailEventForm(Form previous, int idEvent, int idUser, evenement e, String role) {
        super("detail de l'evenement", BoxLayout.y());
        current = this;

        String url = "http://localhost/img/" + e.getImage_event();

        SpanLabel titre = new SpanLabel(e.getTitre_event().toString());

        try {
            ec = EncodedImage.create("/load.png");
            img = URLImage.createToStorage(ec, url, url, URLImage.RESIZE_SCALE);
            iv = new ImageViewer(img);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        SpanLabel categorie = new SpanLabel(e.getCategorie().toString());

        SpanLabel desc = new SpanLabel(e.getDescription().toString());

        SpanLabel dateDeb = new SpanLabel(e.getDate_deb().toString());

        SpanLabel dateFin = new SpanLabel(e.getDate_fin().toString());

        SpanLabel localisation = new SpanLabel(e.getLocation().toString());

        SpanLabel nbMax = new SpanLabel(Integer.toString(e.getNb_max()));

        SpanLabel prix = new SpanLabel(Integer.toString(e.getPrix()));
        createLineSeparator();

        add(titre);
        createLineSeparator();
        add(iv);
        createLineSeparator();
        add(categorie);
        createLineSeparator();
        add(desc);
        createLineSeparator();
        add(dateDeb);
        createLineSeparator();
        add(dateFin);
        createLineSeparator();
        add(localisation);
        createLineSeparator();
        add(nbMax);
        createLineSeparator();
        add(prix);

        Button btnParticiper = new Button("Participer");
        Button btnNePasParticiper = new Button("Ne Participer");
        if (role.equals("client")) {

            add(btnParticiper);
            btnParticiper.addActionListener(p -> {
                Dialog dig = new Dialog("Participation");
                if (dig.show("Participer", "Vous voulez Participer à cet evenement?", "Annuler", "Oui")) {

                    dig.dispose();
                } else {

                    dig.dispose();
                    if(ServiceEvenement.getInstance().participerEvenement(idEvent, idUser)){
                    new MesEvenementsClientForm(idUser, previous).show();

                 
                    }
                }
                
                });
               getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                            g -> previous.showBack()); // Revenir vers l'interface précédente

            }
        }
    }
