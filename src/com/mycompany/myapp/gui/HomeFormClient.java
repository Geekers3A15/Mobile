/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.user;

/**
 *
 * @author USER
 */
public class HomeFormClient extends Form {
    Form current;
    
    
     public HomeFormClient(int idUser,String role) {

        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Accueil Client");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        Button btnListTasks = new Button("Liste des événements");
        Button btnMesEvents = new Button("Mes Evenements");
        Button btnDéc = new Button("Déconnexion");
     

      btnListTasks.addActionListener(e1 -> new ListeEventsForm(current,idUser,role).show());
           btnMesEvents.addActionListener(e2 -> new MesEvenementsClientForm(idUser,current).show());
      
                
        addAll(btnListTasks,btnMesEvents);

    }

}
    

