module com.zzhow.magiccalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.novikoff.calculator to javafx.fxml;
    exports com.novikoff.calculator;
}