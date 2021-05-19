/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import tn.esprit.entities.Formulaire;
import tn.esprit.services.FormulaireService;

/**
 *
 * @author Walid
 */
public class ListeServiceForm extends BaseForm {
    Form current;
    public ListeServiceForm (Resources res ) throws IOException{
        
        
         super("Newsfeed",BoxLayout.y());
       // Toolbar tb=new Toolbar(true);
        current=this;
         setTitle("Liste service");
        //setToolbar(tb);
        getTitleArea().setUIID("container");
        getContentPane().setScrollVisible(false);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //**affichage
        
//        
//        tb.addSearchCommand(e -> {
//            
//        });
//        Tabs swipe=new Tabs();
//        Label s1=new Label();
//        Label s2=new Label();
        
       // addTab(swipe,res.getImage("back-logo.png"),"","",res);
        
        //
        
        //
        
        
        //appel affichage methode
        ArrayList<Formulaire>list=FormulaireService.getInstance().affichageForm();
        for(Formulaire f : list){
            System.out.println("tessssssssssssst");
            
            Image urlImage=res.getImage("background.jpg");
            Image placeHolder=Image.createImage(90,90);
            EncodedImage enc=EncodedImage.createFromImage(placeHolder, false);
            addButton(urlImage,f,res);
            Container containerImg=new Container();
         
        }
        
    
        
        
    }
    
    
       //desgin
    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
        
        int size = Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
        if (image.getHeight()<size){
            image=image.scaledHeight(size);
        }
        if(image.getHeight()>Display.getInstance().getDisplayHeight()/2){
           image=image.scaledHeight(Display.getInstance().getDisplayHeight()/2);
        }
        ScaleImageLabel imageScale=new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay=new Label("","ImageOverlay");
        
        Container page1=
                LayeredLayout.encloseIn(
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text,"LargeWhiteText"),
                                spacer
                        )
                        )
                        
                        
                );
               
        swipe.addTab("",res.getImage("back.png"),page1);
    
    
    
    
        
        
    }
    
    
    public void bindButtonSelection(Button btn,Label l){
        btn.addActionListener((e)->{
            if(btn.isSelected()){
                updateArrowPosition(btn,l);
            }
        });
    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT,btn.getX()+btn.getWidth() /2 -l.getWidth() /2);
        l.getParent();
    }

    private void addButton(Image img,Formulaire f,Resources res) {
        
        int height = Display.getInstance().convertToPixels(11.5f);
         int width = Display.getInstance().convertToPixels(14f);
         
         Button image = new Button(img.fill(width, height));
         image.setUIID("Label");
         Container cnt=BorderLayout.west(image);
         
         //*****affichege****
         Label servTxt= new Label(f.getServiceDemande());
         Label dateTxt= new Label(f.getDateLimite());
         Label statTxt= new Label(f.getStatus());
         Label numTxt= new Label(""+f.getNumTel());
         
         //createLineSeparator();
         
         cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(BoxLayout.encloseX(servTxt),BoxLayout.encloseX(dateTxt),BoxLayout.encloseX(statTxt),BoxLayout.encloseX(numTxt)));
        
         //add(cnt);
        // *****spprimer
         Label lsupprimer=new Label("");
         lsupprimer.setUIID("newsTopLine");
         Style supprimerStyle=new Style(lsupprimer.getUnselectedStyle());
         supprimerStyle.setFgColor(0xf21f1f);
        
        FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lsupprimer.setIcon(supprimerImage);
        lsupprimer.setTextPosition(RIGHT);
        add(lsupprimer);
       
      
       // action delete
        lsupprimer.addPointerPressedListener(l->{
        Dialog dig=new Dialog("suppression");
        
        if(dig.show("suppression","vous voulez vraiment supprimer?","annuler","oui")){
            dig.dispose();
            
        }else{
            dig.dispose();
            //appel supp service
            
            if(FormulaireService.getInstance().deleteFormulaire(f.getIdForm()))
            {
                try {
                    
                    new ListeServiceForm(res);
                } catch (IOException ex) {
                    System.out.println("erreur");
                }
            }
        
        }
    });
        
      //  update icon
        Label lmodifier=new Label("");
         lmodifier.setUIID("newsTopLine");
         Style modifierStyle=new Style(lmodifier.getUnselectedStyle());
         modifierStyle.setFgColor(0xf21f1f);
        
        FontImage modifierImage=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lmodifier.setIcon(modifierImage);
        lmodifier.setTextPosition(LEFT);
        add(lmodifier);
        lmodifier.addPointerPressedListener(l->{
            System.out.println("hello update");
            try {
                Form previous = null;
                new UpdateFormulaireForm(res,f).show();
            } catch (IOException ex) {
                System.out.println("erreur");
            }
        });
        
         add(cnt);
         
      
        
        
    }
    
}
