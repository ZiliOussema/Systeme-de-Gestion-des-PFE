/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.testmaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class Etudiant_consulter_etatController implements Initializable {


    @FXML
    private Button confirmer;
    @FXML
    private Label etat;
    String etat_copie= "état:" ; 
    @FXML
    private Label nome;
    String nome_copie= "nom encadrant:" ; 
    @FXML
    private Label maile;
    String maile_copie= "mail encadrant:" ; 
    @FXML
    private Label nomr;
    String nomr_copie= "nom rapporteur:" ; 
    @FXML
    private Label mailr;
    String mailr_copie= "mail rapporteur:" ; 
    @FXML
    private TextField cin ;  
    @FXML
    private Button consulter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void confirmer_click(MouseEvent event) throws IOException {
          Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }

    @FXML
    private void consulter_click(MouseEvent event) {
        etat.setText(etat_copie); nome.setText(nome_copie);nomr.setText(nomr_copie);maile.setText(maile_copie);mailr.setText(mailr_copie);
          Connection con = null; Statement stmt = null; Statement stmt2 = null;ResultSet res = null;ResultSet res2 = null;ResultSet rs = null;String  etat_text = null ; String  nome_text =" Ce pfe  n' a pas d'encadrant" ; String  nomr_text = " Ce pfe  n' a pas de rapporteur"  ; 
           String  maile_text = " Ce pfe  n' a pas d'encadrant" ; String  mailr_text =" Ce pfe  n' a pas de rapporteur " ;      
           try {
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                        stmt2 = con.createStatement();
                       String querry = " select  etat from pfe  where cin_et1= '" + cin.getText().trim() + "' or cin_et2= '" + cin.getText().trim() + "'";
                       String querry2 = " select *from enseignant ,  pfe  where enseignant.cin_en  =   pfe.encadrant  and ( pfe.cin_et1= '" + cin.getText().trim() + "' or pfe.cin_et2= '" + cin.getText().trim() + "')";
                       String querry3 = " select *from enseignant ,  pfe  where enseignant.cin_en  =   pfe.rapporteur  and ( pfe.cin_et1= '" + cin.getText().trim() + "' or pfe.cin_et2= '" + cin.getText().trim() + "')";

                       rs = stmt2.executeQuery(querry);
                       
                       if(rs.next()== false)
                       {  Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Cet etudiant  n' a  pas de  pfe  !!");
                        a.setHeaderText(null);
                        a.show() ; }
                         rs = stmt2.executeQuery(querry);
                        while(rs.next()== true)
                         { etat_text=rs.getString(1); 
                          }
                           res=stmt.executeQuery(querry2);
                        while(res.next()== true)
                         { nome_text=res.getString(3)+ " "; 
                          nome_text=res.getString(4); 
                          maile_text=res.getString(6); 
                          }
                         res=stmt.executeQuery(querry3);
                         while(res.next()== true)
                         { nomr_text=res.getString(3)+ " "; 
                          nomr_text=res.getString(4); 
                          mailr_text=res.getString(6); 
                          }
                         etat.setText(etat.getText()+" "+etat_text);
                         nome.setText(nome.getText()+" "+nome_text);
                         mailr.setText(mailr.getText()+" "+mailr_text);
                         maile.setText(maile.getText()+" "+maile_text);
                         nomr.setText(nomr.getText()+" "+nomr_text);
                   
                   
                 }    catch (SQLException e) { e.printStackTrace(); }
                      catch (ClassNotFoundException e) { e.printStackTrace(); }  
       
    }

}
