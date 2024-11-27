module com.novikoff.authentification {
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;
    requires java.sql;


    opens com.novikoff.authentification to javafx.fxml;
    exports com.novikoff.authentification;
}