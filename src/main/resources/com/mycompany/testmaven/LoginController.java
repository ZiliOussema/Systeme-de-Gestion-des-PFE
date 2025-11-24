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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussema
 */ 
public class LoginController implements Initializable {
     @FXML
    private ChoiceBox<String> choicebox1;
    @FXML
    private TextField login_text;
    @FXML
    private TextField mdp_text;
    @FXML
    private Button entrer_btn;
    @FXML
    private Button effacer_btn;
    @FXML
    private Button quitter_btn;
   
      
      private   String [] statut  = {"Admin", "Enseignant", "Etudiant"} ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         choicebox1.getItems().addAll(statut) ;   // TODO
    }  
      public   String  getstatut (){
          String  ch =  choicebox1.getValue(); 
          return  ch;   
          
      } 
       

    @FXML
    private void entrer_click(MouseEvent event) throws IOException  {   
       if (choicebox1.getSelectionModel().isEmpty() || mdp_text.getText()==""  ||login_text.getText()=="" )
       {
           Alert a = new Alert(AlertType.ERROR);
           a.setTitle("ATTENTION");
           a.setContentText("veuillez  remplir  tous  les   champs  !!");
           a.setHeaderText(null);
            a.show() ; 
       } 
       else if(getstatut()=="Admin")
       {     Connection con = null; Statement stmt = null; ResultSet rs = null;
                 try {
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = " select  login ,password from admin  where login= '" + login_text.getText().trim() + "' and password = '" + mdp_text.getText().trim() + "'";
                       rs = stmt.executeQuery(querry);
         
                 if(rs.next()==true ) 
                 { /* Alert a = new Alert(AlertType.INFORMATION);
                    a.setTitle(null);
                    a.setContentText("Authentification avec  succes  !!");
                    a.setHeaderText(null);
                    a.show() ; */
                     Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("PageAdmin.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
                   rs.close(); stmt.close(); con.close();  }
                 else  { Alert a = new Alert(AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Admin  introuvable !!");
                        a.setHeaderText(null);
                        a.show() ; 
                     
                 }}
                 catch (SQLException e) { e.printStackTrace(); }
            catch (ClassNotFoundException e) { e.printStackTrace(); } }
       else if(getstatut()=="Enseignant")
       {Connection con = null; Statement stmt = null; ResultSet rs = null;
                 try {
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = " select  login_en ,password_en from enseignant  where login_en= '" + login_text.getText().trim() + "' and password_en= '" + mdp_text.getText().trim() + "'";
                       rs = stmt.executeQuery(querry);
         
                 if(rs.next()==true ) 
                 { Alert a = new Alert(AlertType.INFORMATION);
                    a.setTitle(null);
                    a.setContentText("Authentification avec  succes !!");
                    a.setHeaderText(null);
                    a.show() ; 
                   rs.close(); stmt.close(); con.close();  }
                 else  { Alert a = new Alert(AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText("Enseignant  introuvable !!");
                        a.setHeaderText(null);
                        a.show() ; 
                     
                 }}
                 catch (SQLException e) { e.printStackTrace(); }
            catch (ClassNotFoundException e) { e.printStackTrace(); } 
           
       }
       else if(getstatut()=="Etudiant")
       {Connection con = null; Statement stmt = null; ResultSet rs = null;
                 try {
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = " select  login_et ,password_et from etudiant  where login_et = '" + login_text.getText().trim() + "' and password_et  = '" + mdp_text.getText().trim() + "'";
                       rs = stmt.executeQuery(querry);
         
                 if(rs.next()==true ) 
                 { Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ; 
                   rs.close(); stmt.close(); con.close();  }
                 else  { Alert a = new Alert(AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText("Etudiant  introuvable !!");
                        a.setHeaderText(null);
                        a.show() ; 
                        
                     
                 }}
                 catch (SQLException e) { e.printStackTrace(); }
            catch (ClassNotFoundException e) { e.printStackTrace(); } 
           
         }}
   
    @FXML
    private void effacer_click(MouseEvent event) throws IOException {
         mdp_text.setText("");
         login_text.setText("");  
         choicebox1.setValue(null); 
        /* Node node =  (Node) event.getSource();  
         Stage stage  = (Stage) node.getScene().getWindow() ;  
         Parent  root = FXMLLoader.load(getClass().getResource("PageAdmin.fxml")); 
         Scene  scene= new Scene(root) ; 
         stage.setScene(scene);
         stage.show () ; */
    }

    @FXML
    private void quitter_click(MouseEvent event) { 
        Alert a = new Alert(AlertType.CONFIRMATION);
           a.setTitle(null);
           a.setContentText("Voulez vous vraiment  quitter  !!");
           a.setHeaderText(null);
            a.showAndWait();
         if (a.getResult()==ButtonType.OK)     
         {   
             System.exit(0);}
    }
      
}
