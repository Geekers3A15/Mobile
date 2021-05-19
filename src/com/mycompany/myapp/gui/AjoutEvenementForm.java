/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Properties;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.CN;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.ImageIO;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.entities.user;
import com.mycompany.myapp.services.ServiceEvenement;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class AjoutEvenementForm extends BaseForm {

    Button img1 = new Button("Parcourir");
    Form current;
    user currentUser;
    CheckBox multiSelect = new CheckBox("Multi-select");
    File destFile;

    public AjoutEvenementForm(int idUser, Form previous, String role) {
        super("Ajout evenement", BoxLayout.y());

        getContentPane().setScrollVisible(false);

        TextField titre = new TextField("", "entrer titre");
        titre.setUIID("TextFieldBack");
        addStringValue("titre", titre);

        img1.setUIID("TextFieldBack");
        addStringValue("image", img1);

        ComboBox categorie = new ComboBox();

        categorie.addItem("Photography");
        categorie.addItem("Design");
        categorie.addItem("Music");

        categorie.setUIID("categorie");
        addStringValue("Categorie", categorie);

        TextField description = new TextField("", "entrer description");

        description.setUIID("TextFieldBack");
        addStringValue("description", description);

        Picker dateDeb = new Picker();

        dateDeb.setType(Display.PICKER_TYPE_DATE);

        addStringValue("dateDeb", dateDeb);

        Picker dateFin = new Picker();

        dateFin.setType(Display.PICKER_TYPE_DATE);

        addStringValue("dateFin", dateFin);

        TextField location = new TextField("", "entrer location");

        location.setUIID("TextFieldBack");
        addStringValue("location", location);

        TextField nbMax = new TextField("", "entre nombre max", 11, TextField.NUMERIC);

        nbMax.setUIID("TextFieldBack");
        addStringValue("nbMax", nbMax);

        TextField prix = new TextField("", "entrer le prix", 11, TextField.NUMERIC);

        prix.setUIID("TextFieldBack");
        addStringValue("prix", prix);
        Button btnAjouter = new Button("Ajouter");

        addStringValue("", btnAjouter);

//        TextField image = new TextField("", "entrer image");
//        
        img1.addActionListener((ActionEvent e) -> {
            if (FileChooser.isAvailable()) {
                FileChooser.setOpenFilesInPlace(true);
                FileChooser.showOpenDialog(multiSelect.isSelected(), ".pdf,application/pdf,.gif,image/gif,.mp4,video/mp4,.png,image/png,.jpg,image/jpg,.tif,image/tif,.jpeg", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource() == null) {
                        add("No file was selected");
                        revalidate();
                        return;
                    }
                    if (multiSelect.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }

                    String file = (String) e2.getSource();
                    File filePath = new File(file);
                    if (file == null) {
                        add("No file was selected");

                        revalidate();
                    } else {
                        Image logo;

                        String extension = null;
                        if (file.lastIndexOf(".") > 0) {
                            extension = file.substring(file.lastIndexOf(".") + 1);
                            StringBuilder hi = new StringBuilder(file);

                            if (file.startsWith("file://")) {
                                hi.delete(0, 7);

                            }
                            int lastIndexPeriod = hi.toString().lastIndexOf(".");
                            Log.p(hi.toString());
                            String ext = hi.toString().substring(lastIndexPeriod);
                            String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
                            try {
                                String namePic = saveFileToDevice(file, ext);
//                                SlideService.getInstance().ajouterSlide(filePath, namePic);
                                System.out.println(namePic);

                                btnAjouter.addActionListener((ea) -> {

                                    try {

                                        if (titre.getText() == "") {
                                            Dialog.show("Veuillez vérifier les données ", "", "Annuler", "Ok");

                                        } else {
                                            InfiniteProgress ip = new InfiniteProgress();

                                            final Dialog iDialog = ip.showInfiniteBlocking();
                                            evenement ev = new evenement(idUser, String.valueOf(titre.getText().toString()), (namePic),
                                                    String.valueOf(categorie.getSelectedItem().toString()),
                                                    String.valueOf(description.getText()).toString(),
                                                    String.valueOf(dateDeb.getText()).toString(),
                                                    String.valueOf(dateFin.getText()).toString(),
                                                    String.valueOf(location.getText()).toString(),
                                                    nbMax.getAsInt(BASELINE),
                                                    prix.getAsInt(BASELINE));

                                            System.out.println("data ev" + ev);

                                            ServiceEvenement.getInstance().ajouterEvenement(ev, filePath, namePic);

                                            new ListeEventsForm(current, idUser, role).show();

                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }

                                });
                            } catch (IOException ex) {
                            }
                            revalidate();
                        }
                    }
                });
            }
        });

        Button btnannuler = new Button("Annuler");
        btnannuler.addActionListener(a -> {
            new HomeForm(idUser, role).show();

        });
        add(btnannuler);

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));

        add(createLineSeparator(0xeeeeee));

    }

    protected String saveFileToDevice(String hi, String ext) throws IOException {
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath();
            int index = hi.lastIndexOf("/");
            hi = hi.substring(index + 1);
            return hi;
        } catch (URISyntaxException ex) {
        }
        return "hh";
    }
}
