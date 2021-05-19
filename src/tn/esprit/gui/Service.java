/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.Switch;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author Walid
 */
public class Service extends Form {
    TextField tfNom,tfPrenom,tfEmail,tfNumTel;
    //Switch gender;
    Picker dLimite;
   // CheckBox foot,lecture, tennis,natation;
    Button submit ;
    
    
    public Service(Form previous){
        setTitle("Demande de service");
        this.setLayout(BoxLayout.y());
        tfNom = new TextField("", "Nom");
        tfPrenom = new TextField("", "Prenom");
         tfEmail = new TextField("", "Email");
          tfNumTel = new TextField("", "Num tel");
        
        // gender = new Switch();
        dLimite = new Picker();
        submit = new Button("Submit");
        
         submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0)||(tfPrenom.getText().length()==0)||(tfEmail.getText().length()==0)||(tfNumTel.getText().length()==0)||(dLimite.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                       
                
                
            }
        });
        
        this.addAll(tfNom,tfPrenom,tfEmail,tfNumTel,dLimite,submit);
        
        
        
        
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
    }
    
}
