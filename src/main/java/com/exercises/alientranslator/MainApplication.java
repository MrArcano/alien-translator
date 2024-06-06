package com.exercises.alientranslator;

import com.exercises.alientranslator.model.Dictionary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/fxml/Scene.fxml"));
        Parent root = fxmlLoader.load();

        MainController controller = fxmlLoader.getController();

        Dictionary dictionary = new Dictionary(new HashMap<>());
        controller.setDictionary(dictionary);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(MainApplication.class.getResource("/styles/Styles.css").toString());
        stage.setTitle("Alien Translator!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}