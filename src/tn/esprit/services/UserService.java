/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;import com.codename1.ui.util.Resources;
import java.io.IOException;
;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tn.esprit.entities.User;
import tn.esprit.gui.AjoutService;
import tn.esprit.gui.HomeArtiste;
import tn.esprit.gui.HomeClient;
import tn.esprit.gui.ListeUser;
import tn.esprit.gui.SessionManager;
import tn.esprit.utils.Statics;

/**
 *
 * @author Walid
 */
public class UserService {
    
    public static UserService instance=null;
     private ConnectionRequest req;

    private UserService() {
         req = new ConnectionRequest();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
   //login
    public void login(TextField pseudo,TextField mdp,Resources res ){
         String url=Statics.BASE_URL+"/user/login?pseudo"+pseudo.getText().toString()+"&mdp="+mdp.getText().toString();
           req=new ConnectionRequest(url,false);
           req.setUrl(url);
           req.addResponseListener((e)->{
               
                 JSONParser jsonp;
            JSONParser j=new JSONParser();
            String json=new String(req.getResponseData())+ "";
            try{
                
                    System.out.println("data="+json);
                    Map<String,Object>useres = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
//                    float id_user=Float.parseFloat(useres.get("id_user").toString());
//                     System.out.println("wassssssssssssssssssssssim");
//                    SessionManager.setId_user((int)id_user);
//                  
//                    System.out.println(id_user);
//                    SessionManager.setPseudo(useres.get("pseudo").toString());
//                    SessionManager.setMdp(useres.get("mdp").toString());
//                    SessionManager.setEmail(useres.get("email").toString());
//                    System.out.println("current useres==>"+SessionManager.getPseudo()+" , "+SessionManager.getMdp()+" , "+SessionManager.getEmail());

                  
                   
                   
                    System.out.println("wasssssssssssssssssssssssim11111111111");
                       // new AjoutService(res).show();  
                         //new ListeUser(res).show();
                         new HomeClient(res).show();
                  System.out.println("wasssssssssssssssssimmmmmmm ffffinn");
                    
                
            } catch (Exception ex) {
                  ex.printStackTrace();
             }
               
               
           });
           
           
           
         NetworkManager.getInstance().addToQueueAndWait(req);      
           
    }  
    
  
    
    //affichage User
     public ArrayList<User>affichageListe() {
         
         ArrayList<User> result=new ArrayList<>();
        String url=Statics.BASE_URL+"/user/displayListe";
        req.setUrl(url);
          req.addResponseListener(new ActionListener<NetworkEvent>() {
             @Override
             public void actionPerformed(NetworkEvent evt) {
               JSONParser jsonp;
            jsonp=new JSONParser();
            try{
            Map<String,Object>mapUsers = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
            List<Map<String,Object>>ListOfMaps=(List<Map<String,Object>>)mapUsers.get("root");
            
            for(Map<String,Object>obj:ListOfMaps) {
                User u=new User();
                // float id_user = Float.parseFloat(obj.get("id_user").toString());
                  String nom=obj.get("nom").toString();
                  String prenom=obj.get("prenom").toString();
                  String role=obj.get("role").toString();
                 //  u.setId_user((int)id_user);
                   u.setNom(nom);
                   u.setPrenom(prenom);
                   u.setRole(role);
                   
                      result.add(u);
            
          
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
        
             
        });
           NetworkManager.getInstance().addToQueueAndWait(req);          
           return result;
         
     }
    

}
