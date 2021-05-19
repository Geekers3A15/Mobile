/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.esprit.entities.Formulaire;
import tn.esprit.services.FormulaireService;


/**
 *
 * @author Walid
 */
public class AjoutService extends BaseForm {
    
    Form current;
    public AjoutService (Resources res){
        super("Newsfeed",BoxLayout.y());
       
        current=this;
         setTitle("ajout service");
//          Toolbar tb=new Toolbar(true);
//        setToolbar(tb);
        getTitleArea().setUIID("container");
        getContentPane().setScrollVisible(false);
//        Form previous = Display.getInstance().getCurrent();
//        tb.setBackCommand("", e -> previous.showBack());
      //  getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
//        tb.addSearchCommand(e -> {
//            
//        });
        Tabs swipe=new Tabs();
        Label s1=new Label();
       Label s2=new Label();
        //addTab(swipe, s2, res.getImage("back-logo.jpg"), "", "", res);
       //addTab(swipe,res.getImage("back-logo.png"),"","",res);
//        
        
        //modif 
        //
        
        
        
        
        //
        
        
        TextField serviceDemande =new TextField("","enter votre service");
        serviceDemande.setUIID("textFieldBlack");
        addStringValue("serviceDemande",serviceDemande);
        
        TextField numTel =new TextField("","enter votre service");
        serviceDemande.setUIID("textFieldBlack");
        addStringValue("numTel",numTel);
        
        Picker dateLimite = new Picker();
        dateLimite.setType(Display.PICKER_TYPE_DATE);
        addStringValue("dateLimite", dateLimite);
        
         TextField status =new TextField("","enter votre service");
        serviceDemande.setUIID("textFieldBlack");
        addStringValue("status",status);
        
        Button btnAjouter = new Button("ajouter");
        addStringValue("",btnAjouter);
        
        
        //event button ajouter
        
        btnAjouter.addActionListener((e)->{
            
            try{
            if ((serviceDemande.getText().length()==0)||(numTel.getText().length()==0)||(dateLimite.getText().length()==0)){
                    Dialog.show("Alert", "Please fill all the fields", "annuler","OK");
            }
            else {
                    InfiniteProgress ip =new InfiniteProgress();//loading after isnert date
                    final Dialog iDialog=ip.showInfiniteBlocking();
                    Formulaire f = new Formulaire(String.valueOf(serviceDemande.getText()
                    ).toString(),
                            String.valueOf(dateLimite.getText()).toString(),
                            String.valueOf(status.getText()).toString(),
                            Integer.valueOf(numTel.getText()));
                    
                    System.out.println("service =="+f);
                    
                    //appel service web
                    FormulaireService.getInstance().ajouterFormulaire(f);
                    
                    iDialog.dispose(); //no loading
                    
                    refreshTheme();//refresh
                    new ListeServiceForm(res).show();
                    
                    sendMail(res);
                    iDialog.dispose();
                    Dialog.show("service","OK");
                    refreshTheme();
                    
                    
                    
                    
                    }
            }catch(Exception ex){
                ex.printStackTrace();
            }
       
               
            
            
        });
        
       
        
        
        
        
        
                
        
        
    }

    private void addStringValue(String s, Component v) {
      add(BorderLayout.west(new Label(s,"paddedLabe"))
      .add(BorderLayout.CENTER,v));
      add(createLineSeparator(0xeeeeee));
    }

    //desgin
//    private void addTab(Tabs swipe,Label spacer,Image image, String string, String text, Resources res) {
//        
//        int size = Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
//        if (image.getHeight()<size){
//            image=image.scaledHeight(size);
//        }
//        if(image.getHeight()>Display.getInstance().getDisplayHeight()/2){
//           image=image.scaledHeight(Display.getInstance().getDisplayHeight()/2);
//        }
//        ScaleImageLabel imageScale=new ScaleImageLabel(image);
//        imageScale.setUIID("Container");
//        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//        
//        Label overLay=new Label("","ImageOverlay");
//        
//        Container page1=
//                LayeredLayout.encloseIn(overLay,
//                        BorderLayout.south(BoxLayout.encloseY(
//                        new SpanLabel(text,"LargeWhiteText"),
//                                FlowLayout.encloseIn(null),
//                                spacer
//                        )
//                        )
//                        
//                        
//                );
//               
//        swipe.addTab("",res.getImage("back-logo.jpg"),page1);
//        
//        
//    }
    
    
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
    
    
    public void sendMail(Resources res){
        try{

	Properties props=new Properties();
	props.put("mail.transport.protocol","smtp");
	props.put("mail.smtps.host","smtp.gmail.com");
	props.put("mail.smtps.auth","true");

	Session session=Session.getInstance(props,null);


	MimeMessage msg= new MimeMessage(session);
        msg.setFrom("me@example.com");
	//msg.setForm(new InternetAddress("me@example.com"));
	msg.setRecipients(Message.RecipientType.TO, "farah.msallem@esprit.tn");
	//msg.setSubject("app nom:confiramtion");
         msg.setSubject("Jakarta Mail hello world example");
        msg.setSentDate(new Date());
        msg.setText("Hello, world!\n");  
	//msg.setText(txt);
         //Transport.send(msg, "medwael39@gmail.com", "Farah1919");
	SMTPTransport st= (SMTPTransport)session.getTransport("smtps");
	st.connect("smtp.gmail.com",587,"medwael39@gmail.com","Farah1919");
	st.sendMessage(msg, msg.getAllRecipients());
	        System.out.println("serveur response" +st.getLastServerResponse());


} catch(Exception ex){
	ex.printStackTrace();
}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   







}
