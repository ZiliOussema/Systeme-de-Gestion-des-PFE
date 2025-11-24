module com.mycompany.testmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql ; 
    opens com.mycompany.testmaven to javafx.fxml;
    exports com.mycompany.testmaven;
}
