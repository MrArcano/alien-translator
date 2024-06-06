package com.exercises.alientranslator.model;

import java.util.*;

public class Dictionary {
    private Map<String, Set<String>> dictionary;

    public Dictionary(Map<String, Set<String>> dictionary) {
        this.dictionary = dictionary;
    }

    public void addTranslate(String alienWord, String translate){
        Set<String> set;
        // se alienWord NON è nel dizionario
        if(!this.dictionary.containsKey(alienWord)){
            set = new HashSet<>();
        } else { // se alienWord è nel dizionario
            set = this.dictionary.get(alienWord);
        }
        set.add(translate);
        this.dictionary.put(alienWord,set);
        System.out.println("Dictionary: " + dictionary);
    }

    public String getTranslate(String alienWord){
        Set<String> set = this.dictionary.get(alienWord);
        return set!=null ? set.toString() : "Non trovato";
    }

}
