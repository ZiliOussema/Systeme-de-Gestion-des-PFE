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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class Etudiant_DepotSujetController implements Initializable {


    @FXML
    private TextField nom1;
    @FXML
    private TextField prenom1;
    @FXML
    private TextField cin1;
    @FXML
    private Button annuler;
    @FXML
    private Button deposer;
    @FXML
    private TextField nom2;
    @FXML
    private TextField prenom2;
    @FXML
    private TextField cin2;
    @FXML
    private TextArea sujet;
    @FXML
    private TextField entreprise;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void deposer_click(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
      if ( nom1.getText()==""  ||prenom1.getText()==""||cin1.getText()==""||sujet.getText()==""||entreprise.getText()=="")   
      { Alert a = new Alert(Alert.AlertType.ERROR);
           a.setTitle("ATTENTION");
           a.setContentText("veuillez  remplir  tous  les   champs obligatoires  !!");
           a.setHeaderText(null);
            a.show() ; 
      }
      else 
      {Connection con = null; Statement stmt = null; ResultSet rs = null;ResultSet res = null; Statement stmt2 = null;ResultSet res3 = null; Statement stmt3 = null;
        if ( nom2.getText()=="" &&prenom2.getText()==""&&cin2.getText()=="")
        { Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       stmt2 = con.createStatement();
                       String querry = " select  * from etudiant where nom_et= '" + nom1.getText().trim() + "' and prenom_et = '" + prenom1.getText().trim() + "' and cin_et = '" + cin1.getText().trim() + "'";
                       String querry2 = " select  * from pfe where cin_et1= '" + cin1.getText().trim()+"'";
                       res=stmt2.executeQuery(querry2);
                       rs = stmt.executeQuery(querry);
              if(res.next()==true && rs.next()==true )
            {Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Cet etudiant a  deja  un pfe  !!");
                        a.setHeaderText(null);
                        a.show() ; 
                   }
              else if(res.next()==true ) 
              {Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Etudiant introuvable !!");
                        a.setHeaderText(null);
                        a.show() ; 
                  
              }
            else{
                 if(rs.next()==true ) 
                 {  String  insert  ="insert  into pfe values('"+sujet.getText()+"','"+entreprise.getText() +"','"+cin1.getText().trim() +"',NULL,'en attente d encadrement',NULL,NULL,NULL,NULL) "; 
                     stmt = con.createStatement();
                   int i   = stmt.executeUpdate(insert);
                    if  (i ==0) 
                        
                    {Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Probleme dans  l'ajout  du pfe  !!");
                        a.setHeaderText(null);
                        a.show() ; 
                        
                    }
                    else
                    {Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle(null);
                        a.setContentText("Ajout   du  pfe  avec  succes    !!");
                        a.setHeaderText(null);
                        a.showAndWait() ; 
                        if (a.getResult() ==ButtonType.OK)
                        {Node node =  (Node) event.getSource();  
                          Stage stage  = (Stage) node.getScene().getWindow() ;  
                          Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                            Scene  scene= new Scene(root) ; 
                             stage.setScene(scene);
                             stage.show () ;
                            
                        }
                        
                    }
                        
                 }
                 else  { Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" etudiant   introuvable !!");
                        a.setHeaderText(null);
                        a.show() ; 
                     
                       }
               }
        } 
        else  
        {Class.forName("oracle.jdbc.driver.OracleDriver");
                       con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
                       stmt = con.createStatement();
                       stmt2 = con.createStatement();
                       stmt3 = con.createStatement();
                       String querry = " select  * from etudiant where nom_et= '" + nom1.getText().trim() + "' and prenom_et = '" + prenom1.getText().trim() + "' and cin_et = '" + cin1.getText().trim() + "'";
                        String querry3 = " select  * from etudiant where nom_et= '" + nom2.getText().trim() + "' and prenom_et = '" + prenom2.getText().trim() + "' and cin_et = '" + cin2.getText().trim() + "'";
                       String querry2 = " select  * from pfe where cin_et1= '" + cin1.getText().trim()+"' or cin_et2 ='"+ cin1.getText().trim()+"'";
                      res=stmt2.executeQuery(querry2);
                      res3=stmt3.executeQuery(querry3) ; 
                       rs = stmt.executeQuery(querry);
             if (res.next()==true && (rs.next()==true||res3.next()==true) ) 
            {Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" L'un de ces deux etudiants a  deja  un pfe  !!");
                        a.setHeaderText(null);
                        a.show() ; 
                   }
             else if(res.next()==true){
                 Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" L' un ou  les  deux  etudiants est/sont    introuvable(s) !!");
                        a.setHeaderText(null);
                        a.show() ; 
             }
            else {
                 if(rs.next()==true && res3.next()==true ) 
                 {  String  insert  ="insert  into pfe values('"+sujet.getText()+"','"+entreprise.getText() +"','"+cin1.getText().trim() +"','"+cin2.getText().trim() +"','en attente d encadrement',NULL,NULL,NULL,NULL) "; 
                     stmt = con.createStatement();
                   int i   = stmt.executeUpdate(insert);
                    if  (i ==0) 
                        
                    {Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" Probleme dans  l'ajout  du pfe  !!");
                        a.setHeaderText(null);
                        a.show() ; 
                        
                    }
                    else
                    {Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle(null);
                        a.setContentText("Ajout   du  pfe  avec  succes    !!");
                        a.setHeaderText(null);
                        a.showAndWait() ; 
                        if (a.getResult() ==ButtonType.OK)
                        {Node node =  (Node) event.getSource();  
                          Stage stage  = (Stage) node.getScene().getWindow() ;  
                          Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                            Scene  scene= new Scene(root) ; 
                             stage.setScene(scene);
                             stage.show () ;
                            
                        }
                        
                    }
                        
                 }
                 else 
                 { Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("ATTENTION");
                        a.setContentText(" L' un ou  les  deux  etudiants est/sont    introuvable(s) !!");
                        a.setHeaderText(null);
                        a.show() ; 
                     
                       }
                }  
            
        }
      }
    }

    @FXML
    private void annuler_click(MouseEvent event) throws IOException {
        Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("PageEtudiant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }

}
