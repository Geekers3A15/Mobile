/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import tn.esprit.entities.Formulaire;
import tn.esprit.services.FormulaireService;

/**
 *
 * @author Walid
 */
public class UpdateFormulaireForm extends BaseForm {
    Form current;
    public UpdateFormulaireForm(Resources res, Formulaire f) throws IOException{
        
         super("Newsfeed",BoxLayout.y());
        //Toolbar tb=new Toolbar(true);
        current=this;
        setTitle("Mise à jour");
       // setToolbar(tb);
//        Form previous = Display.getInstance().getCurrent();
//        tb.setBackCommand("", e -> previous.showBack());
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        getTitleArea().setUIID("container");
        
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);
        
        TextField service=new TextField(f.getServiceDemande(),"votre service",20,TextField.ANY);
        add(service);
       TextField numTel =new TextField(String.valueOf(f.getNumTel()),"votre num",20,TextField.ANY);
       add(numTel);
      Picker dateLimite = new Picker();
        dateLimite.setType(Display.PICKER_TYPE_DATE);
        addStringValue("dateLimite", dateLimite);
        TextField etat =new TextField(f.getStatus(),"service",20,TextField.ANY);
        ComboBox etatCombo = new ComboBox();
        etatCombo.addItem("confirmer");
        etatCombo.addItem("non confirmer");
        if (f.getStatus()=="confirmer"){
            etatCombo.setSelectedIndex(0);
        }
        else {
            etatCombo.setSelectedIndex(1);
        }
        add(etat);
        
        service.setUIID("NewsTopLine");
        numTel.setUIID("NewsTopLine");
        dateLimite.setUIID("NewsTopLine");
          etat.setUIID("NewsTopLine");
          
          service.setSingleLineTextArea(true);
          numTel.setSingleLineTextArea(true);
         //dateLimite.setSingleLineTextArea(true);
          etat.setSingleLineTextArea(true);
          
          
          Button btnModifier= new Button("modifier");
          btnModifier.setUIID("Button");
          add(btnModifier);
          
          //event
          btnModifier.addPointerPressedListener(l->{
              f.setServiceDemande(service.getText());
              f.setNumTel(Integer.parseInt(numTel.getText()));
              f.setDateLimite(dateLimite.getText());
              f.setStatus(etat.getText());
          
          
          //appel modifer
          
          if(FormulaireService.getInstance().modiferFormulaire(f)){
              System.out.println("erreuuu");
                  try {
                      new UpdateFormulaireForm(res,f).show();
                  } catch (IOException ex) {
                      System.out.println("erreur");
                  }
              

          }
          });
          Button btnAnnuler=new Button("annuler");
          btnAnnuler.addActionListener(l->{
             try {
                 new ListeServiceForm(res).show();
             } catch (IOException ex) {
                 System.out.println("erreur");
             }
             
             
             
          });
          add(btnAnnuler);
          
          
        
             
                 
        
        
        
        
        
        
        
        
        
        
        
    }

    private void addStringValue(String s, Component v) {
         add(BorderLayout.west(new Label(s,"paddedLabe"))
      .add(BorderLayout.CENTER,v));
      add(createLineSeparator(0xeeeeee));
    }
    
    
}
