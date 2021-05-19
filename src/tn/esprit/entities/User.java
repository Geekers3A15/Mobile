/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;




/**
 *
 * @author Walid
 */
public class User {
    
     private int idUser;
   private String nom;
    private String prenom;
    private String  pseudo;
    private String mdp;
    private String email;
    private String role;
    private String bio;
    private String photo_profil;
   
    public User(){
        
    }    

    public User(int idUser, String nom, String prenom, String pseudo, String mdp, String email, String role, String bio, String photo_profil) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.role = role;
        this.bio = bio;
        this.photo_profil = photo_profil;
    }

    public int getidUser() {
        return idUser;
    }

    public void setId_user(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto_profil() {
        return photo_profil;
    }

    public void setPhoto_profil(String photo_profil) {
        this.photo_profil = photo_profil;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", email=" + email + ", role=" + role + ", bio=" + bio + ", photo_profil=" + photo_profil + '}';
    }
    
    
    
    
    
    
    
    
    
}
