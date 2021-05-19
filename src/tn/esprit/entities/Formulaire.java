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
public class Formulaire {
    
    private int idForm,idUser,idUserCli;
    private String serviceDemande,dateLimite,status;
    private int numTel;
    
    public Formulaire(){
        
    }

    public Formulaire(int idForm, int idUser, int idUserCli, String serviceDemande, String dateLimite, String status, int numTel) {
        this.idForm = idForm;
        this.idUser = idUser;
        this.idUserCli = idUserCli;
        this.serviceDemande = serviceDemande;
        this.dateLimite = dateLimite;
        this.status = status;
        this.numTel = numTel;
    }

    public Formulaire(int idUser, int idUserCli, String serviceDemande, String dateLimite, String status, int numTel) {
        this.idUser = idUser;
        this.idUserCli = idUserCli;
        this.serviceDemande = serviceDemande;
        this.dateLimite = dateLimite;
        this.status = status;
        this.numTel = numTel;
    }

    public Formulaire(String serviceDemande, String dateLimite, String status, int numTel) {
        this.serviceDemande = serviceDemande;
        this.dateLimite = dateLimite;
        this.status = status;
        this.numTel = numTel;
    }

    public Formulaire(String serviceDemande) {
        this.serviceDemande = serviceDemande;
    }

    
    
    

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserCli() {
        return idUserCli;
    }

    public void setIdUserCli(int idUserCli) {
        this.idUserCli = idUserCli;
    }

    public String getServiceDemande() {
        return serviceDemande;
    }

    public void setServiceDemande(String serviceDemande) {
        this.serviceDemande = serviceDemande;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
    
    



}