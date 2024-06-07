package com.exercises.alientranslator;

import com.exercises.alientranslator.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    private Dictionary dictionary;

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField lblTesto;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {
        txtResult.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
        String s = lblTesto.getText();
        lblTesto.setText("");
        if(s.matches("[a-zA-Z ?]+")){
            String[] strings = s.toLowerCase().split(" ");
            if (strings.length == 1){
                String translate = dictionary.getTranslate(strings[0]);
                txtResult.appendText(translate + "\n");
            }
            if(strings.length > 1){
                dictionary.addTranslate(strings[0],strings[1]);
            }
        }else {
            txtResult.appendText("Errore di inserimento!\n");
        }
    }

    @FXML
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}