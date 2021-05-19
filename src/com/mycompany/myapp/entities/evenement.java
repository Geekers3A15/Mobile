/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author USER
 */
public class evenement {
    private int id_event;
    private int id_artiste;
    private String titre_event;
    private String image_event;
    private String categorie;
    private String description;
    private String date_deb;
    private String date_fin;
    private String location;
    private int nb_max;
    private int prix;

    public evenement() {
    }

    public evenement(String titre_event, String image_event) {
        this.titre_event = titre_event;
        this.image_event = image_event;
    }

    public evenement(int id_artiste, String titre_event, String categorie, String description, String date_deb, String date_fin, String location, int nb_max, int prix) {
        this.id_artiste = id_artiste;
        this.titre_event = titre_event;
        this.categorie = categorie;
        this.description = description;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.location = location;
        this.nb_max = nb_max;
        this.prix = prix;
    }

    public evenement(int id_event, int id_artiste, String titre_event, String categorie, String description, String date_deb, String date_fin, String location, int nb_max, int prix) {
        this.id_event = id_event;
        this.id_artiste = id_artiste;
        this.titre_event = titre_event;
        this.categorie = categorie;
        this.description = description;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.location = location;
        this.nb_max = nb_max;
        this.prix = prix;
    }

    public evenement(String titre_event, String image_event, String categorie, String description, String date_deb, String date_fin, String location, int nb_max, int prix) {
        this.titre_event = titre_event;
        this.image_event = image_event;
        this.categorie = categorie;
        this.description = description;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.location = location;
        this.nb_max = nb_max;
        this.prix = prix;
    }
    

    public evenement(int id_event, int id_artiste, String titre_event, String image_event, String categorie, String description, String date_deb, String date_fin, String location, int nb_max, int prix) {
        this.id_event = id_event;
        this.id_artiste = id_artiste;
        this.titre_event = titre_event;
        this.image_event = image_event;
        this.categorie = categorie;
        this.description = description;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.location = location;
        this.nb_max = nb_max;
        this.prix = prix;
    }

    public evenement(int id_artiste, String titre_event, String image_event, String categorie, String description, String date_deb, String date_fin, String location, int nb_max, int prix) {
        this.id_artiste = id_artiste;
        this.titre_event = titre_event;
        this.image_event = image_event;
        this.categorie = categorie;
        this.description = description;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.location = location;
        this.nb_max = nb_max;
        this.prix = prix;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public String getTitre_event() {
        return titre_event;
    }

    public void setTitre_event(String titre_event) {
        this.titre_event = titre_event;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNb_max() {
        return nb_max;
    }

    public void setNb_max(int nb_max) {
        this.nb_max = nb_max;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "evenement{" + "id_event=" + id_event + ", id_artiste=" + id_artiste + ", titre_event=" + titre_event + ", image_event=" + image_event + ", categorie=" + categorie + ", description=" + description + ", date_deb=" + date_deb + ", date_fin=" + date_fin + ", location=" + location + ", nb_max=" + nb_max + ", prix=" + prix + '}';
    }
    
    
    
}
