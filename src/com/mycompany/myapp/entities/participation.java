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
public class participation {
    private int id_event;
    private int id_client;

    public participation() {
    }

    public participation(int id_event, int id_client) {
        this.id_event = id_event;
        this.id_client = id_client;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "participation{" + "id_event=" + id_event + ", id_client=" + id_client + '}';
    }
    
    
}
