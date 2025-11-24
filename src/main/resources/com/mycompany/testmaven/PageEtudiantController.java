/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.testmaven;



import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PageEtudiantController {

    @FXML
    private Button deconnexion;

    @FXML
    private ImageView etat_img;

    @FXML
    private Label etat_txt;

    @FXML
    private ImageView rapport_img;

    @FXML
    private Label rapport_txt;

    @FXML
    private ImageView sujet_img;

    @FXML
    private Label sujet_txt;

    @FXML
    void deconnexion_click(MouseEvent event) throws IOException {
         Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("login.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;

    }

    @FXML
    void etat_click(MouseEvent event) throws IOException {
        Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("Etudiant_consulter_etat.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ; 

    }

    @FXML
    void rapport_click(MouseEvent event) throws IOException {
              Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("Etudiant_DepotRapport.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;

    }

    @FXML
    void sujet_click(MouseEvent event) throws IOException {
         Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("Etudiant_DepotSujet.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;

    }

}
