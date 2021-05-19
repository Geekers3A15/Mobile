/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.user;
import java.io.IOException;
import javafx.scene.image.ImageView;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
   

    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    public HomeForm(int idUser, String role) {

        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Accueil Artiste");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        Button btnAddTask = new Button("Ajouter une événement");
        Button btnListTasks = new Button("Liste des événements");
        Button btnMesEvents = new Button("Mes Evenements");
        Button btnDéc = new Button("Déconnexion");
        btnAddTask.addActionListener(e -> new AjoutEvenementForm( idUser , current,role).show());

        btnListTasks.addActionListener(e1 -> new ListeEventsForm(current,idUser,role).show());
           btnMesEvents.addActionListener(e2 -> new MesEvenementsForm(idUser,current,role).show());
      
                
        addAll(btnAddTask, btnListTasks,btnMesEvents);
        

    }

}
