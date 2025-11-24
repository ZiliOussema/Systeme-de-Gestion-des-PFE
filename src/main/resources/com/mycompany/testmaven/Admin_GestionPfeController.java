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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class Admin_GestionPfeController implements Initializable {


    @FXML
    private ImageView retour;
    @FXML
    private TableView<?> table;
    @FXML
    private TextField etudiant;
    @FXML
    private TextField encadrant;
    @FXML
    private TextField rapporteur;
    @FXML
    private Button enregistrer;
    @FXML
    private Button effacer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void retour_click(MouseEvent event) throws IOException {
          Node node =  (Node) event.getSource();  
        Stage stage  = (Stage) node.getScene().getWindow() ;  
        Parent  root = FXMLLoader.load(getClass().getResource("PageAdmin.fxml")); 
        Scene  scene= new Scene(root) ; 
        stage.setScene(scene);
        stage.show () ;
    }

    @FXML
    private void enregistrer_click(MouseEvent event) {
    }

    @FXML
    private void efacer_click(MouseEvent event) {
    }

}
