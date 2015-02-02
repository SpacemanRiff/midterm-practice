package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
    private int misses, correctLetters;
    
    public Hangman() {
        misses = 0;
        word = "";
        usedLetters = new ArrayList<Character>();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean available(char c) {
        return !usedLetters.contains(c);
    }
    
    public int guess(char c) {
        int numberOfOccurences = 0;
        if(!usedLetters.contains(c)){
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == c){
                    numberOfOccurences++;
                }
            }
            usedLetters.add(c);
            if(numberOfOccurences == 0){
                misses++;
            }
        }
        correctLetters = numberOfOccurences;
        return numberOfOccurences;
    }
    
    public Result getResult() {
        if(misses == 6){
            return Result.LOSE;
        }else{
            if(checkForWin()){
                return Result.WIN;
            }else{
                return Result.NONE;
            }            
        }
    }
    
    private boolean checkForWin(){
        if(misses != 0){
            if(correctLetters == word.length()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}












