/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.testmaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Etudiant_DepotRapportController {

    @FXML
    private Button annuler;

    @FXML
    private TextField cin;

    @FXML
    private Button confirmer;

    @FXML
    private Button deposer;
        @FXML
    private ListView<String> pfeview;
    private ListView<File> pfefiles=new ListView<File>()  ;

    @FXML
    void annuler_click(MouseEvent event) throws IOException {
       Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }

    @FXML
    void confirmer_click(MouseEvent event) throws FileNotFoundException, SQLException, ClassNotFoundException, IOException {
        {      if (cin.getText()=="" || pfeview.getItems().isEmpty() )
               {
                      Alert a = new Alert(AlertType.ERROR);
                      a.setTitle("ATTENTION");
                      a.setContentText("veuillez  remplir  tous  les   champs  !!");
                      a.setHeaderText(null);
                      a.show() ; 
                } 
                else {  Connection con = null; Statement stmt = null; ResultSet rs = null;
                      
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       String querry = " select * from pfe  where cin_et1='" + cin.getText().trim() + "' or cin_et2 = '" + cin.getText().trim() + "'";
                       rs = stmt.executeQuery(querry);
         
                 if(rs.next()==true ) 
                 {            if(rs.getString("encadrant")==null)
                               { Alert a = new Alert(AlertType.WARNING);
                                  a.setTitle("ATTENTION");
                                  a.setContentText("Votre pfe n'est  pas encadré !!");
                                  a.setHeaderText(null);
                                  a.show() ; } 
                              else{ String querry_update =  "update pfe   set rapport =? ,etat='en attente d’un rapporteur' where  cin_et1 ='"+cin.getText().trim()+"'or cin_et2= '"+cin.getText().trim()+"'" ;  
                                       PreparedStatement pstmt = con.prepareStatement(querry_update);
                                       File file = pfefiles.getItems().get(0); 
                                       FileInputStream  input= new FileInputStream(file) ;
                                       pstmt.setBinaryStream(1, input);
                                       int  i= pstmt.executeUpdate(); 
                                       if ( i==0) 
                                       {Alert a = new Alert(AlertType.ERROR);
                                         a.setTitle("ATTENTION");
                                         a.setContentText("Erreur dans l'ajout du rapport. Veuillez réessayer  !!");
                                         a.setHeaderText(null);
                                         a.show() ;
                                       }
                                       else
                                       {Alert a = new Alert(AlertType.INFORMATION);
                                         a.setTitle(null);
                                         a.setContentText("Ajout avec  succes !!");
                                         a.setHeaderText(null);
                                         a.showAndWait() ;
                                         if (a.getResult()==ButtonType.OK)     
                                          {Node node =  (Node) event.getSource();  
                                             Stage stage  = (Stage) node.getScene().getWindow() ;  
                                            Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                                            Scene  scene= new Scene(root) ; 
                                             stage.setScene(scene);
                                              stage.show () ; } 
                                         
                                         }
                                     
                                  rs.close(); stmt.close(); con.close();  }}
               else  { Alert a = new Alert(AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText("Numero de CIN  erroné!!");
                        a.setHeaderText(null);
                        a.show() ; 
                     
                 }
                 }
        }
    }

    @FXML
    void deposer_click(MouseEvent event) {
        FileChooser fc  = new FileChooser () ; 
        fc.setInitialDirectory(new  File("C:\\Users\\Oussema\\OneDrive\\Bureau\\POO AV"));
        fc.getExtensionFilters().add(new ExtensionFilter("PDF FILES ","*.pdf")) ; 
        File selectedfile = fc.showOpenDialog(null); 
        if( selectedfile !=  null)
        {pfeview.getItems().add(selectedfile.getName());  
         pfefiles.getItems().add(selectedfile.getAbsoluteFile()) ; 
       
        }
        else{
            Alert a = new Alert(AlertType.ERROR);
                    a.setTitle(null);
                    a.setContentText("Fichier  invalide!!");
                    a.setHeaderText(null);
                    a.show() ;
        }

    }

}