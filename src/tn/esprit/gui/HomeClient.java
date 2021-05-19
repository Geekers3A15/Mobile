/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Walid
 */
public class HomeClient extends Form {
     Form current;
    public HomeClient(Resources res){
         current=this;
         setTitle("Home");
        setLayout(BoxLayout.y());
        
         add(new Label("Choose an option"));
        Button btnListe = new Button("Liste des artistes");
        Button btnConfCli = new Button("Liste des confirmé");
        Button btnForm = new Button("Demande de service");
         btnListe.addActionListener(e -> new ListeUser(res).show());
         btnConfCli.addActionListener(e -> new TabConfirmation(current).show());
         //btnForm.addActionListener(e -> new AjoutService(current).show());
          addAll(btnListe, btnConfCli,btnForm);
        
        
    }
    
}
