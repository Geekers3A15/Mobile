/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.user;
import com.mycompany.myapp.gui.BaseForm;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.gui.HomeFormClient;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author USER
 */
public class UserService extends BaseForm {

    public static UserService instance = null;

    public static boolean res = true;

    private ConnectionRequest req;
    user u ;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }

        return instance;

    }

    public UserService() {
        req = new ConnectionRequest();

    }

    public void signin(TextField pseudo, TextField mdp, Resources rs) {
        String url = Statics.BASE_URL + "/user/signin?pseudo=" + pseudo.getText().toString()
                + "&mdp=" + mdp.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();

            String json = new String(req.getResponseData()) + "";

            try {

                if (json.equals("erreur2")) {
                    Dialog.show("Echec", "U our mdp", "Ok", null);
                } else {
                    System.out.println("Data" + json);
                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    if (user.size() > 0) { //user found
                         String role = user.get("role").toString();
                         int idUser = (int)Float.parseFloat(user.get("idUser").toString());
                         if (role.equals("artiste")){
                              new HomeForm(idUser,role).show();
                         }else{
                             new HomeFormClient(idUser,role).show();
                             
                         }
                       
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);

    }

}
