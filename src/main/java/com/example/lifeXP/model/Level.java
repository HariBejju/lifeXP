package com.example.lifeXP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int levelNumber;
    private int xpRequired;
    private int xpPerTask;

    @ManyToOne
    @JoinColumn(name="dimension_id")
    private Dimension dimension_id;

    public void setLevelNumber(int levelNumber){
        this.levelNumber = levelNumber;
    }
    public int getLevelNumber(){
        return levelNumber;
    }
    public void setXpRequired(int xpRequired){
        this.xpRequired = xpRequired;
    }
    public int getXpRequired(){
        return xpRequired;
    }
    public void setXpPerTask(int xpPerTask){
        this.xpPerTask = xpPerTask;
    }
    public int getXpPerTask(){
        return xpPerTask;
    }
    
}
