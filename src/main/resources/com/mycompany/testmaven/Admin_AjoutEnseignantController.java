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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class Admin_AjoutEnseignantController implements Initializable {


    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
    @FXML
    private Button annuler;
    @FXML
    private Button ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void annuler_click(MouseEvent event) throws IOException {
           Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("Admin_GestionEnseignants.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }
       public   boolean  trouve  ()
    {boolean test = false ; 
        Connection con = null; Statement stmt = null; ResultSet  rs = null ; 
                 try {
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = " select  *  from enseignant  where nom_en= '" + nom.getText().trim() + "' and prenom_en = '" + prenom.getText().trim() + "' and cin_en = '" + cin.getText().trim() + "' and email_en = '" + email.getText().trim() +"'" ;
                        rs = stmt.executeQuery(querry);
                 if(rs.next()==true ) 
                 { test= true  ; 
                   rs.close(); stmt.close(); con.close();  }
                 else  {   test=  false ;   }}
                 catch (SQLException e) { e.printStackTrace(); }
            catch (ClassNotFoundException e) { e.printStackTrace(); }
     return test ; 
    }
    @FXML
    private void ajouter_click(MouseEvent event) {
        
        
        if ((cin.getText() == "") || (nom.getText()== "") || (prenom.getText() == "")||(email.getText() == "") )
        {Alert a = new Alert(Alert.AlertType.ERROR);
           a.setTitle("ATTENTION");
           a.setContentText("veuillez  remplir  tous  les   champs  !!");
           a.setHeaderText(null);
            a.show() ; 
            
        }
        else  if  ( trouve())
        {Alert a = new Alert(Alert.AlertType.ERROR);
           a.setTitle("ATTENTION");
           a.setContentText("Etudiant  déja existant !!");
           a.setHeaderText(null);
            a.show() ; 
            
        }
        else
        {
          Connection con = null; Statement stmt = null; 
                 try { String   login  = nom.getText() + prenom.getText()  ; 
                        
                         Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = "INSERT INTO ENSEIGNANT VALUES('" + login+ "','" + cin.getText() + "','" + nom.getText() + "','" + prenom.getText() + "','"+ cin.getText() +"','"+ email.getText()+ "')"  ;                       
                       int i =stmt.executeUpdate(querry) ;  
                 if(i>0 ) 
                 {  Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle(null);
                    a.setContentText("Ajout  avec  succes  !!");
                    a.setHeaderText(null);
                    a.show() ; 
                    
                    stmt.close(); con.close();  }
                 else  { Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("ATTENTION");
                        a.setContentText("Echec de  l'ajout  !!");
                        a.setHeaderText(null);
                        a.show() ; }
                     
                 }
                 catch (SQLException e) { e.printStackTrace(); }
            catch (ClassNotFoundException e) { e.printStackTrace(); } } 
        
    }

}
