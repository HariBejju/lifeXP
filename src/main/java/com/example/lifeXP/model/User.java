package com.example.lifeXP.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this makes auto generated value of ID which increments 
    private Long id;
    private String username;
    private String email;
    private String password;
    private int xp=0;
    private int tasksCompleted=0;

    public User(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public User() {
        //TODO Auto-generated constructor stub
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }
}
