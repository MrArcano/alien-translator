package com.exercises.alientranslator.model;

import java.util.Map;
import java.util.Optional;

public class Dictionary {
    private Map<String,String > dictionary;

    public Dictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void selectOperation(String s){

    }

    public boolean addTranslate(String alienWord, String translate){
        // se la parola è già inserita nel dizionario, ritorno falso e non la inserisco
        if(this.dictionary.containsKey(alienWord)) return false;
        // se la parola non è già nel dizionario allora aggiungo la parola, e ritorno falso
        this.dictionary.put(alienWord, translate);
        System.out.println("Dictionary: " + dictionary);
        return true;
    }

    public String getTranslate(String alienWord){

        return Optional.ofNullable(this.dictionary.get(alienWord)).orElse("Non trovato");
    }

}
