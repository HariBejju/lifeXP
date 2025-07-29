package com.example.lifeXP.dto;

 //DTOs are needed coz
 //1. separation of concerns
 //2. security
 //3. future updates in model structure wont disturb API calls.
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    
    private void setUsername(String username){
        this.username=username;
    }
    private void setEmail(String email){
        this.email = email;
    }
    private void setPassword(String password){
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
