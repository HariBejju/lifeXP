package com.example.lifeXP.dto;

public class ProgressResponseDTO {
    
    private String dimension;
    private int currentLevel;
    private int currentXP;

    public int getCurrentLevel(){
        return currentLevel;
    }
    public void setCurrentLevel(int currentLevel){
        this.currentLevel = currentLevel;
    }
    public String getDimension(){
        return dimension;
    }
    public void setDimension(String dimension){
        this.dimension = dimension;
    }
    public void setCurrentXp(int currentXp){
        this.currentXP = currentXp;
    }
    public int getCurrentXp(){
     return currentXP;   
    }

}
