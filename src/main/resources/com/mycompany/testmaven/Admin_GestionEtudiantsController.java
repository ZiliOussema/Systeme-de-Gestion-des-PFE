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
public class Admin_GestionEtudiantsController implements Initializable {

    @FXML
    private ImageView retour;
    @FXML
    private TableView<etudiant> table_et = new TableView<>();
    @FXML
    private TableColumn<etudiant, String> cin = new TableColumn<>("CIN"); 

    @FXML
    private TableColumn<etudiant, String> login= new TableColumn<>("LOGIN");

    @FXML
    private TableColumn<etudiant, String> mdp = new TableColumn<>("MDP");

    @FXML
    private TableColumn<etudiant, String> nom= new TableColumn<>("NOM");

    @FXML
    private TableColumn<etudiant, String> prenom= new TableColumn<>("PRENOM");
      @FXML
    private TableColumn<etudiant, String> email= new TableColumn<>("EMAIL");
   
   
    ObservableList<etudiant>  StudentList = FXCollections.observableArrayList();
    @FXML
    private Button ajouter;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.setCellValueFactory(new PropertyValueFactory<etudiant, String>("login"));
        mdp.setCellValueFactory(new PropertyValueFactory<etudiant, String>("mdp"));
        nom.setCellValueFactory(new PropertyValueFactory<etudiant, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<etudiant, String>("prenom"));
        cin.setCellValueFactory(new PropertyValueFactory<etudiant, String>("cin"));
        email.setCellValueFactory(new PropertyValueFactory<etudiant, String>("email"));
        table_et.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
       try {String query = null;
             Connection conn = null ;
             Statement stmt = null ;
             ResultSet res = null ;
             StudentList.clear();
             Class.forName("oracle.jdbc.driver.OracleDriver");
             conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521/xe","poo","poo");
             stmt = conn.createStatement();
             query = "SELECT * FROM etudiant";
               res=stmt.executeQuery(query); 
           
               
            while (res.next()){
               etudiant et =   new  etudiant(
                        res.getString("login_et"),
                        res.getString("password_et"),
                        res.getString("nom_et"),
                        res.getString("prenom_et"),
                        res.getString("cin_et"),
                        res.getString("email_et"));
                        StudentList.add(et);
                   }
                
                table_et.setItems(StudentList);
                  table_et.getColumns().setAll(nom,prenom, login, mdp, cin,email);
               
                
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
                    Parent  root = FXMLLoader.load(getClass().getResource("Admin_AjoutEtudiant.fxml")); 
                    Scene  scene= new Scene(root) ; 
                    stage.setScene(scene);
                    stage.show () ;
    }
    
}
