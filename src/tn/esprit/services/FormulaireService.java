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
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tn.esprit.entities.Formulaire;
import tn.esprit.utils.Statics;

/**
 *
 * @author Walid
 */
public class FormulaireService {
    public static FormulaireService instance=null;
    public static boolean resultOk=true;
    //initialistation request
    private ConnectionRequest req;
    

    private FormulaireService() {
         req = new ConnectionRequest();
    }

    public static FormulaireService getInstance() {
        if (instance == null) {
            instance = new FormulaireService();
        }
        return instance;
    }
    //ajout 
    public void ajouterFormulaire(Formulaire formulaire){
        String url=Statics.BASE_URL+"/addFormulaire?serviceDemande="+formulaire.getServiceDemande()+"&numTel="+formulaire.getNumTel()
                +"&dateLimite="+formulaire.getDateLimite()+"&status="+formulaire.getStatus();
        req.setUrl(url);
        req.addResponseListener((a)-> {
            String str=new String(req.getResponseData());
            System.out.println("data="+str);
        });
        
         NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    
    //affichage
    public ArrayList<Formulaire>affichageForm() throws IOException{
        
        ArrayList<Formulaire> result=new ArrayList<>();
        String url=Statics.BASE_URL+"/displayFormulaire";
        req.setUrl(url);
           
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               JSONParser jsonp;
            jsonp=new JSONParser();
            try{
            Map<String,Object>mapFormulaires = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
            List<Map<String,Object>>ListOfMaps=(List<Map<String,Object>>)mapFormulaires.get("root");
            
            for(Map<String,Object>obj:ListOfMaps){
                Formulaire f=new Formulaire();
                float idForm = Float.parseFloat(obj.get("idForm").toString());
               // float idUser = Float.parseFloat(obj.get("idUser").toString());
               // float idUserCli = Float.parseFloat(obj.get("idUserCli").toString());
                String serviceDemande=obj.get("serviceDemande").toString();
                float numTel = Float.parseFloat(obj.get("numTel").toString());
                //String dateLimite=obj.get("dateLimite").toString();
                String status=obj.get("status").toString(); 
                
                f.setIdForm((int)idForm);
               // f.setIdUser((int)idUser);
               // f.setIdUserCli((int)idUserCli);
                f.setServiceDemande(serviceDemande);
                f.setNumTel((int)numTel);
               // f.setDateLimite(dateLimite);
               // Date
               // String DateConverter=obj.get("dateLimite").toString().substring(obj.get("dateLimite").indexOf("timestamp")+10,o)
                f.setStatus(status);
               result.add(f);
            
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
        });
        
        

       NetworkManager.getInstance().addToQueueAndWait(req);          
           return result;
    }      
                

//delete
    public boolean deleteFormulaire(int idForm){
        //nthabet fel url
        String url=Statics.BASE_URL+"/deleteForm?idForm="+idForm;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              req.removeResponseListener(this);
            }
        });
        
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOk ;
                 
    }


//update
    public boolean modiferFormulaire(Formulaire formulaire){
        
      
          String url=Statics.BASE_URL+"/updateForm?idForm="+formulaire.getIdForm()+"&serviceDemande="+formulaire.getServiceDemande()+"&numTel="+formulaire.getNumTel()
                +"&dateLimite="+formulaire.getDateLimite()+"&status="+formulaire.getStatus();
          System.out.println(url);
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk=req.getResponseCode()==200;  //code response http 200 ok
              req.removeResponseListener(this);
            }
        });
        
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOk ;
    }

}