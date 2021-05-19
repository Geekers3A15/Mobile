package com.mycompany.myapp.entities;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class user {

    private int id_user;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;
    private String date_naiss;
    private String tel;
    private String email;
    private String role;
    private String bio;
    private String photo_profil;

    public user() {
    }

    public user(int id_user) {
        this.id_user = id_user;
    }

    public user(int id_user, String nom, String prenom, String pseudo, String mdp, String date_naiss, String tel, String email, String role, String bio, String photo_profil) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.date_naiss = date_naiss;
        this.tel = tel;
        this.email = email;
        this.role = role;
        this.bio = bio;
        this.photo_profil = photo_profil;
    }

    public user(String nom, String prenom, String pseudo, String mdp, String date_naiss, String tel, String email, String role, String bio, String photo_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.date_naiss = date_naiss;
        this.tel = tel;
        this.email = email;
        this.role = role;
        this.bio = bio;
        this.photo_profil = photo_profil;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        return "user{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", date_naiss=" + date_naiss + ", tel=" + tel + ", email=" + email + ", role=" + role + ", bio=" + bio + ", photo_profil=" + photo_profil + '}';
    }

}
