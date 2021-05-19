/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import tn.esprit.entities.Formulaire;
import tn.esprit.entities.User;
import tn.esprit.services.FormulaireService;
import tn.esprit.services.UserService;


/**
 *
 * @author Walid
 */
public class ListeUser extends BaseForm {
    
     Form current;
    public ListeUser(Resources res){
        super("Newsfeed",BoxLayout.y());
      //  Toolbar tb=new Toolbar(true);
        current=this;
         setTitle("Liste des artistes");
       // setToolbar(tb);
        getTitleArea().setUIID("container");
        getContentPane().setScrollVisible(false);
        
        ArrayList<User>list=UserService.getInstance().affichageListe();
        for(User f : list){
            System.out.println("tessssssssssssst"); 
          Label NTxt= new Label("Nom"+f.getNom());
         Label PTxt= new Label("Prenom"+f.getPrenom());
         Label RTxt= new Label("Role"+f.getRole());
          Container cnt=BorderLayout.center(NTxt);
          add(cnt);
          Container cnt1=BorderLayout.west(PTxt);
          add(cnt1);
           Container cnt2=BorderLayout.center(RTxt);
          add(cnt2);
         //cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(BoxLayout.encloseX(NTxt),BoxLayout.encloseX(PTxt),BoxLayout.encloseX(RTxt)));
         Button btnRserver=new Button("reserver");
         btnRserver.addPointerPressedListener(l->{
             System.out.println("acctiveee");
           new AjoutService(res).show();
         });
         add(btnRserver);
            
        }
    
    
    
}

//    private void addButton(Image img,User f,Resources res) {
//       int height = Display.getInstance().convertToPixels(11.5f);
//         int width = Display.getInstance().convertToPixels(14f);
//         
//         Button image = new Button(img.fill(width, height));
//         image.setUIID("Label");
//         Container cnt=BorderLayout.west(image);
//         
//         //affichage
//        
//         Label NTxt= new Label(f.getNom());
//         Label PTxt= new Label(f.getPrenom());
//         Label RTxt= new Label(f.getRole());
//         cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(BoxLayout.encloseX(NTxt),BoxLayout.encloseX(PTxt),BoxLayout.encloseX(RTxt)));
//         
//    }
    
    
    
    
    
    
}
