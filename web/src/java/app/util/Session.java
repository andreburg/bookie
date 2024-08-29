/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.util;
import app.controller.DataController;

public class Session {
    private final String username;
    private final DataController dc;
    
    public Session(String username){
        this.username = username;
        this.dc = new DataController();
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public boolean validateSession() throws ClassNotFoundException{
        if(username.equals("")) return false;
        
        return this.dc.isUsernameTaken(this.username);
    }
}