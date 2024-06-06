module com.exercises.alientranslator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exercises.alientranslator to javafx.fxml;
    exports com.exercises.alientranslator;
}