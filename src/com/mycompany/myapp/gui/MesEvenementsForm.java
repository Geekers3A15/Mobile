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
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceEvenement;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class MesEvenementsForm extends BaseForm {

    Form current;
    public static evenement e;

    public MesEvenementsForm(int idUser, Form previous, String role) {

        setTitle("Mes Evenements Artiste");
        setLayout(BoxLayout.y());
current=this;
        ArrayList<evenement> liste = ServiceEvenement.getInstance().affichageMesEvenements(idUser);
        for (evenement e : liste) {
            Button t = new Button(e.getTitre_event());

            add(t);

            createLineSeparator();

            FloatingActionButton lSupp = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE);
            FloatingActionButton lMod = FloatingActionButton.createFAB(FontImage.MATERIAL_EDIT);
            add(lSupp);
            add(lMod);

            lSupp.addActionListener(l -> {

                Dialog dig = new Dialog("Suppression");
                if (dig.show("Supprimer", "Vous voulez supprimer cet evenement?", "Annuler", "Oui")) {

                    dig.dispose();

                } else {

                    dig.dispose();

                    if (ServiceEvenement.getInstance().deleteEvenement(e.getId_event())) {

                        new HomeForm(idUser, role).show();

                    }

                }

            });
            lMod.addActionListener(l -> {
                System.out.println("hello ");
                new ModifierEventForm(idUser, current, e, role).show();

            });

            t.addActionListener(d -> {
                new detailEventForm(previous, e.getId_event(), idUser, e, role).show();

            });
                    
       

    
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                    g -> previous.showBack()); // Revenir vers l'interface précédente

        }
    }
}