/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;

/**
 *
 * @author Walid
 */
public class ConfirmationArtiste extends Form {
     Form current;
    
    public ConfirmationArtiste(Form previous){
        current=this;
        
         setTitle("Confirmation d'un service");
        
       // Form  = new Form("Table", new BorderLayout());
TableModel model = new DefaultTableModel(new String[] {"Col 1", "Col 2", "Col 3"}, new Object[][] {
    {"Row 1", "Row A", "Row X"},
    {"Row 2", "Row B", "Row Y"},
    {"Row 3", "Row C", "Row Z"},
    {"Row 4", "Row D", "Row K"},
    }) {
        public boolean isCellEditable(int row, int col) {
            return col != 0;
        }
    };
Table table = new Table(model);
this.add(BorderLayout.CENTER, table);
this.show();

        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
    }
    
}
