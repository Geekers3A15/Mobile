/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceEvenement;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class MesEvenementsClientForm extends BaseForm {

    Form current;

    public MesEvenementsClientForm(int idUser, Form previous) {

        setTitle("Mes Evenements Client");
        setLayout(BoxLayout.y());

        ArrayList<evenement> liste = ServiceEvenement.getInstance().affichageMesEvenementsClient(idUser);
        for (evenement e : liste) {
            Button t = new Button(e.getTitre_event());

            add(t);

            createLineSeparator();

            t.addActionListener(d -> {
//                new detailEventClientForm(previous, e.getId_event(), idUser, e).show();

            });

        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                g -> previous.showBack()); // Revenir vers l'interface précédente

    }

}
