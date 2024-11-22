module com.novikoff.authentication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.novikoff.authentication to javafx.fxml;
    exports com.novikoff.authentication;
}