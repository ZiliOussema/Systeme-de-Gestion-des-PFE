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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Oussema
 */
public class Admin_GestionEnseignantsController implements Initializable {


    @FXML
    private ImageView retour;
    @FXML
    private TableView<enseignant> table_en = new TableView<>();
    @FXML
    private TableColumn<enseignant, String> cin = new TableColumn<>("CIN"); 

    @FXML
    private TableColumn<enseignant, String> login= new TableColumn<>("LOGIN");

    @FXML
    private TableColumn<enseignant, String> mdp = new TableColumn<>("MDP");

    @FXML
    private TableColumn<enseignant, String> nom= new TableColumn<>("NOM");

    @FXML
    private TableColumn<enseignant, String> prenom= new TableColumn<>("PRENOM");
    @FXML
    private TableColumn<enseignant, String> email= new TableColumn<>("EMAIL");
   
    ObservableList<enseignant>  professorList = FXCollections.observableArrayList();
    @FXML
    private Button ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         login.setCellValueFactory(new PropertyValueFactory<enseignant, String>("login"));
        mdp.setCellValueFactory(new PropertyValueFactory<enseignant, String>("mdp"));
        nom.setCellValueFactory(new PropertyValueFactory<enseignant, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<enseignant, String>("prenom"));
        cin.setCellValueFactory(new PropertyValueFactory<enseignant, String>("cin"));
         email.setCellValueFactory(new PropertyValueFactory<enseignant, String>("email"));
        table_en.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
       try {String query = null;
             Connection conn = null ;
             Statement stmt = null ;
             ResultSet res = null ;
          professorList.clear();
             Class.forName("oracle.jdbc.driver.OracleDriver");
             conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
             stmt = conn.createStatement();
             query = "SELECT * FROM enseignant";
               res=stmt.executeQuery(query); 
           
               
            while (res.next()){
               enseignant en =   new  enseignant(
                        res.getString("login_en"),
                        res.getString("password_en"),
                        res.getString("nom_en"),
                        res.getString("prenom_en"),
                       res.getString("cin_en"),
                        res.getString("email_en"));
                     professorList.add(en);
                   }
                
                table_en.setItems(professorList);
                  table_en.getColumns().setAll(nom,prenom, login, mdp, cin,email);
               
                
                  } catch (SQLException e) { e.printStackTrace(); }
                    catch (ClassNotFoundException e) { e.printStackTrace(); } 
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
    private void ajouter_click(MouseEvent event) throws IOException {
          Node node =  (Node) event.getSource();  
                    Stage stage  = (Stage) node.getScene().getWindow() ;  
                    Parent  root = FXMLLoader.load(getClass().getResource("Admin_AjoutEnseignant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }

}
