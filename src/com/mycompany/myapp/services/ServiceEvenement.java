/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import static com.codename1.processing.Result.JSON;
import com.codename1.ui.Dialog;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.entities.participation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ServiceEvenement {

    public static ServiceEvenement instance = null;

    public static boolean res = true;

    private ConnectionRequest req;

    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }

        return instance;

    }

    public ServiceEvenement() {
        req = new ConnectionRequest();

    }

    public void ajouterEvenement(evenement event, File file, String nameFile) {
        MultipartRequest request = new MultipartRequest();

        String url = Statics.BASE_URL + "/new";
        request.setUrl(url);
        request.setPost(true);

        try {
            String urll = file.toString();

            System.out.println(nameFile);
            request.addData("file", urll, "application/json");
            request.addArgument("name", nameFile);

            request.addArgument("idArtiste", event.getId_artiste() + "");
            request.addArgument("titreEvent", event.getTitre_event());
            request.addArgument("categorie", event.getCategorie());
            request.addArgument("description", event.getDescription());
            request.addArgumentNoEncoding("dateDeb", event.getDate_deb());

            request.addArgumentNoEncoding("dateFin", event.getDate_fin());
            request.addArgument("location", event.getLocation());
            request.addArgument("nbMax", event.getNb_max() + "");
            request.addArgument("prix", event.getPrix() + "");

        } catch (IOException ex) {

        }

        NetworkManager.getInstance().addToQueueAndWait(request);

    }

    public ArrayList<evenement> affichageEvenement() {
        ArrayList<evenement> result = new ArrayList<>();

        String url = Statics.BASE_URL + "/showacceuilevent";
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapEvents = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapEvents.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        evenement e = new evenement();

                        float idEvent = Float.parseFloat(obj.get("idEvent").toString());

                        String titreEvent = obj.get("titreEvent").toString();
                        String imageEvent = obj.get("imageEvent").toString();
                        String categorie = obj.get("categorie").toString();
                        String description = obj.get("description").toString();
                        String dateDeb = obj.get("dateDeb").toString();
                        String dateFin = obj.get("dateFin").toString();
                        String location = obj.get("location").toString();

                        float nbMax = Float.parseFloat(obj.get("nbMax").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());

                        e.setId_event((int) idEvent);
                        e.setTitre_event(titreEvent);
                        e.setImage_event(imageEvent);
                        e.setCategorie(categorie);
                        e.setDescription(description);
                        e.setDate_deb(dateDeb);
                        e.setDate_fin(dateFin);
                        e.setLocation(location);

                        e.setNb_max((int) nbMax);
                        e.setPrix((int) prix);

                        result.add(e);

                    }

                } catch (Exception ex) {

                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;

    }

    public ArrayList<evenement> affichageEvenementClient(int idUser) {
        ArrayList<evenement> result = new ArrayList<>();

        String url = Statics.BASE_URL + "/showacceuilmeseventsclient/" + idUser;
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapEvents = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapEvents.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        evenement e = new evenement();

                        float idEvent = Float.parseFloat(obj.get("idEvent").toString());

                        String titreEvent = obj.get("titreEvent").toString();
                        String imageEvent = obj.get("imageEvent").toString();
                        String categorie = obj.get("categorie").toString();
                        String description = obj.get("description").toString();
                        String dateDeb = obj.get("dateDeb").toString();
                        String dateFin = obj.get("dateFin").toString();
                        String location = obj.get("location").toString();

                        float nbMax = Float.parseFloat(obj.get("nbMax").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());

                        e.setId_event((int) idEvent);
                        e.setTitre_event(titreEvent);
                        e.setImage_event(imageEvent);
                        e.setCategorie(categorie);
                        e.setDescription(description);
                        e.setDate_deb(dateDeb);
                        e.setDate_fin(dateFin);
                        e.setLocation(location);

                        e.setNb_max((int) nbMax);
                        e.setPrix((int) prix);

                        result.add(e);

                    }

                } catch (Exception ex) {

                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;

    }

    public ArrayList<evenement> affichageMesEvenements(int idUser) {
        ArrayList<evenement> result = new ArrayList<>();

        String url = Statics.BASE_URL + "/indexEvent/" + idUser;
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapEvents = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapEvents.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        evenement e = new evenement();

                        float idEvent = Float.parseFloat(obj.get("idEvent").toString());

                        String titreEvent = obj.get("titreEvent").toString();
                        String imageEvent = obj.get("imageEvent").toString();
                        String categorie = obj.get("categorie").toString();
                        String description = obj.get("description").toString();
                        String dateDeb = obj.get("dateDeb").toString();
                        String dateFin = obj.get("dateFin").toString();
                        String location = obj.get("location").toString();

                        float nbMax = Float.parseFloat(obj.get("nbMax").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());

                        e.setId_event((int) idEvent);
                        e.setTitre_event(titreEvent);
                        e.setImage_event(imageEvent);
                        e.setCategorie(categorie);
                        e.setDescription(description);
                        e.setDate_deb(dateDeb);
                        e.setDate_fin(dateFin);
                        e.setLocation(location);

                        e.setNb_max((int) nbMax);
                        e.setPrix((int) prix);

                        result.add(e);

                    }

                } catch (Exception ex) {

                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }

    public ArrayList<evenement> affichageMesEvenementsClient(int idUser) {
        ArrayList<evenement> result = new ArrayList<>();

        String url = Statics.BASE_URL + "/showacceuilmeseventsclient/" + idUser;
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapEvents = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapEvents.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        evenement e = new evenement();

                        float idEvent = Float.parseFloat(obj.get("idEvent").toString());

                        String titreEvent = obj.get("titreEvent").toString();
                        String imageEvent = obj.get("imageEvent").toString();
                        String categorie = obj.get("categorie").toString();
                        String description = obj.get("description").toString();
                        String dateDeb = obj.get("dateDeb").toString();
                        String dateFin = obj.get("dateFin").toString();
                        String location = obj.get("location").toString();

                        float nbMax = Float.parseFloat(obj.get("nbMax").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());

                        e.setId_event((int) idEvent);
                        e.setTitre_event(titreEvent);
                        e.setImage_event(imageEvent);
                        e.setCategorie(categorie);
                        e.setDescription(description);
                        e.setDate_deb(dateDeb);
                        e.setDate_fin(dateFin);
                        e.setLocation(location);

                        e.setNb_max((int) nbMax);
                        e.setPrix((int) prix);

                        result.add(e);

                    }

                } catch (Exception ex) {

                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;

    }

    public evenement detailEvenement(int idEvent, evenement event) {
        String url = Statics.BASE_URL + "/singleshowevent/" + idEvent;
        req.setUrl(url);

        String str = new String((req.getResponseData()));
        req.addResponseListener((evt -> {

            JSONParser jsonp;
            jsonp = new JSONParser();
            try {
                Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                event.getTitre_event().toString();
                System.out.println(event.getTitre_event().toString());
            } catch (IOException ex) {
                System.out.println("error mon ami:" + ex.getMessage());
            }

            System.out.println("Data ====" + str);

        }));

        NetworkManager.getInstance().addToQueueAndWait(req);

        return event;

    }

    public evenement detailEvenementClient(int idEvent, int idUser, evenement event) {
        String url = Statics.BASE_URL + "/singleshoweventclient/" + idEvent + "/" + idUser;
        req.setUrl(url);

        String str = new String((req.getResponseData()));
        req.addResponseListener((evt -> {

            JSONParser jsonp;
            jsonp = new JSONParser();
            try {
                Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                event.setTitre_event(obj.get("titreEvent").toString());
                event.setImage_event(obj.get("imageEvent").toString());
                event.setCategorie(obj.get("categorie").toString());
                event.setDescription(obj.get("description").toString());
                event.setDate_fin(obj.get("dateFin").toString());
                event.setNb_max(Integer.parseInt(obj.get("nbMax").toString()));
                event.setPrix(Integer.parseInt(obj.get("prix").toString()));

            } catch (IOException ex) {
                System.out.println("error mon ami:" + ex.getMessage());
            }

            System.out.println("Data ====" + str);

        }));

        NetworkManager.getInstance().addToQueueAndWait(req);

        return event;

    }

    public boolean deleteEvenement(int idEvent) {
        String url = Statics.BASE_URL + "/delete/" + idEvent;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseCodeListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return res;

    }

    public boolean updateEvenement(evenement event, int idUser) {
        String url = Statics.BASE_URL + "/edit/?idEvent=" + event.getId_event() + "&idArtiste=" + idUser + "&titreEvent=" + event.getTitre_event() + "&imageEvent=" + event.getImage_event()
                + "&categorie=" + event.getCategorie() + "&description=" + event.getDescription()
                + "&dateDeb=" + event.getDate_deb() + "&dateFin=" + event.getDate_fin()
                + "&location=" + event.getLocation() + "&nbMax=" + event.getNb_max()
                + "&prix=" + event.getPrix();

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance()
                .addToQueueAndWait(req);
        return res;

    }

    public boolean participerEvenement(int idEvent, int idUser) {

        String url = Statics.BASE_URL + "/parrt/" + idUser + "/" + idEvent;

        req.setUrl(url);

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(res);
        return res;

    }

    public boolean participerOuNonEvenement(int idEvent, int idUser) {

        String url = Statics.BASE_URL + "/partOuNon/" + idUser + "/" + idEvent;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser js = new JSONParser();
                js.equals("null");
                req.getHttpMethod();
                System.out.println("res data  "+js.equals("null"));
            }
           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println("res "+res);
       return res;

    }
}
