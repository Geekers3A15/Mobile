/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import static com.sun.javafx.fxml.expression.Expression.add;
import tn.esprit.services.UserService;

/**
 *
 * @author Walid
 */
public class SignInForm extends BaseForm{
    
     public SignInForm(Resources res) {
         super(new BorderLayout());
         setTitle("login");
       // Toolbar tb = new Toolbar(true);
       // setToolbar(tb);
       // tb.setUIID("Container");
        getTitleArea().setUIID("Container");
       // Form previous = Display.getInstance().getCurrent();
      //  tb.setBackCommand("", e -> previous.showBack());
        setUIID("Activate");
        
        add(BorderLayout.SOUTH, 
                BoxLayout.encloseY(
                        new Label(res.getImage("background.jpg"), "LogoLabel"),
                        new Label("Awsome Thanks!", "LogoLabel")
                )
        );
        
        add(BorderLayout.NORTH,
                BoxLayout.encloseX(
                new Label(res.getImage("logo1.png"), "LogoLabel")));
                //new Label(res.getImage("logo1.png"), "LogoLabel"));
        
        TextField username = new TextField("", "pseudo", 20, TextField.ANY);
        TextField password = new TextField("", "mdp", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
       
        
        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
               // createLineSeparator(),
                new FloatingHint(password),
              //  createLineSeparator(),
                signIn
                //FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );
        content.setScrollableY(true);
       //
       add(BorderLayout.CENTER, content);
        signIn.requestFocus();
        signIn.addActionListener(e -> {
            UserService.getInstance().login(username, password, res);
        });
    }
    
}
