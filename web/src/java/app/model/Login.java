/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;
import app.util.PasswordUtils;

public class Login {
    private final int id;
    private final String username;
    private final String password;
      
    public Login(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public boolean validatePassword(String compares){
        return PasswordUtils.validatePassword(compares, this.password);
    }
}
