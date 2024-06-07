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
        // controllo se esiste o meno questa key
        Set<String> set = this.dictionary.get(alienWord);
        // se lo trovo ritorno il sett
        if(set!=null) return set.toString();

        // se NON lo trovo
        List<String> listKey = checkWithWildcard(alienWord, this.dictionary.keySet());
        StringBuilder result = new StringBuilder();
        for (String key : listKey){
            result.append(this.dictionary.get(key).toString());
        }
        return String.valueOf(result);
    }

    private List<String> checkWithWildcard(String alienWord, Set<String> keySet) {
        List<String> listKey = new ArrayList<>();
        char[] charsAlienWord = alienWord.toCharArray();
        changeKey: for (String key : keySet){
            // se le lunghezze sono diverse vuol dire che non sono uguali
            if (alienWord.length() != key.length()) continue;

            // se le lunghezze sono uguali, allora devo controllare carattere per carattere
            char[] charsKey = key.toCharArray();
            int countWildcard = 0;
            for (int i = 0; i < alienWord.length(); i++) {
                // se i caratteri sono diversi
                if(charsAlienWord[i] != charsKey[i]){
                    // se il carattere diverso è uguale a '?' e non ce ne sono stati altri
                    if(charsAlienWord[i] == '?' && countWildcard < 1) {
                        countWildcard++;
                        continue; // passo alla prossima lettera
                    }
                    continue changeKey; //c'è stato un carattere diverso o più wildcard e quindi passo alla prossima key
                }
            }
            // dopo aver controllato carattere per carattere, vuol dire che la key è valida
            // quindi la salvo in una lista e continuo il ciclo
            listKey.add(key);
        }
        return listKey;
    }

}
