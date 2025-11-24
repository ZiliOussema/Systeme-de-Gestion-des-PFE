/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.testmaven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class PageAdminController implements Initializable {


    @FXML
    private ImageView etudiant;
    @FXML
    private ImageView enseignant;
    @FXML
    private ImageView pfe;
    @FXML
    private Button deconnexion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void etudiant_click(MouseEvent event) throws IOException {
        Node node =  (Node) event.getSource();  
        Stage stage  = (Stage) node.getScene().getWindow() ;  
        Parent  root = FXMLLoader.load(getClass().getResource("Admin_GestionEtudiants.fxml")); 
        Scene  scene= new Scene(root) ; 
        stage.setScene(scene);
        stage.show () ;
    }

    @FXML
    private void enseignant_click(MouseEvent event) throws IOException {
        Node node =  (Node) event.getSource();  
        Stage stage  = (Stage) node.getScene().getWindow() ;  
        Parent  root = FXMLLoader.load(getClass().getResource("Admin_GestionEnseignants.fxml")); 
        Scene  scene= new Scene(root) ; 
        stage.setScene(scene);
        stage.show () ;
    }

    @FXML
    private void pfe_click(MouseEvent event) throws IOException {
        Node node =  (Node) event.getSource();  
        Stage stage  = (Stage) node.getScene().getWindow() ;  
        Parent  root = FXMLLoader.load(getClass().getResource("Admin_GestionPfe.fxml")); 
        Scene  scene= new Scene(root) ; 
        stage.setScene(scene);
        stage.show () ;
    }

    @FXML
    private void deconnexion_click(MouseEvent event) throws IOException { 
         Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("login.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }

}

