/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.io.Preferences;

/**
 *
 * @author Walid
 */
public class SessionManager {
    
    public static  Preferences pref;
    private static int id_user;
    private static String pseudo;
    private static String email;
    private static String mdp;
    
    public static Preferences getPref(){
       
        return pref;
    }
    public static void setPref(Preferences pref){
        SessionManager.pref=pref;
    }
    
    

    public static int getId_user() {
        return pref.get("id_user",id_user);
    }

    public static void setId_user(int id_user) {
        pref.get("id_user",id_user);
    }

    public static String getPseudo() {
        return pref.get("pseudo",pseudo);
    }

    public static void setPseudo(String pseudo) {
       pref.set("pseudo",pseudo);
    }

    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
       pref.get("email",email);
    }

    public static String getMdp() {
        return pref.get("mdp",mdp);
    }

    public static void setMdp(String mdp) {
      pref.get("mdp",mdp);
    }
    
    
    
    
    
    
    
    
    
}
